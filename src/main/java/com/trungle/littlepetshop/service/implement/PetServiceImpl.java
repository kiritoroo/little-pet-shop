package com.trungle.littlepetshop.service.implement;

import com.trungle.littlepetshop.exception.ResourceNotFoundException;
import com.trungle.littlepetshop.model.Breed;
import com.trungle.littlepetshop.model.Pet;
import com.trungle.littlepetshop.model.Picture;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.PetRequest;
import com.trungle.littlepetshop.repository.BreedRepository;
import com.trungle.littlepetshop.repository.PetRepository;
import com.trungle.littlepetshop.service.FileStorageService;
import com.trungle.littlepetshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public List<Pet> getPetsList() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPet(Long id) {
        return petRepository
            .findById(id)
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Pet")
                    .fieldName("ID")
                    .fieldValue(id)
                    .build()
            );
    }

    @Override
    public Pet createPet(PetRequest petRequest) {
        Breed breed = breedRepository
            .findById(petRequest.getBreed())
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("breed")
                    .fieldName("ID")
                    .fieldValue(petRequest.getBreed())
                    .build()
            );

        Pet newPet = Pet.builder()
            .name(petRequest.getName())
            .description(petRequest.getDescription())
            .age(petRequest.getAge())
            .gender(petRequest.getGender())
            .color(petRequest.getGender())
            .breed(breed)
            .build();

        if (!Objects.equals(petRequest.getPicture().getOriginalFilename(), "")) {
            String fileName = Instant.now().getEpochSecond() + "_" + petRequest.getPicture().getOriginalFilename().toLowerCase();
            String fieUrl = MessageFormat.format("/statics/{0}", fileName);
            Picture picture = Picture.builder()
                .name(fileName)
                .url(fieUrl)
                .pet(newPet)
                .build();
            newPet.setPicture(picture);

            fileStorageService.save(
                petRequest.getPicture(),
                fileName
            );
        }

        return petRepository.save(newPet);
    }

    @Override
    public Pet updatePet(Long id, PetRequest petRequest) {
        Pet updatedPet = this.getPet(id);

        Breed breed = breedRepository
            .findById(petRequest.getBreed())
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("breed")
                    .fieldName("ID")
                    .fieldValue(petRequest.getBreed())
                    .build()
            );

        updatedPet.setName(petRequest.getName());
        updatedPet.setDescription(petRequest.getDescription());
        updatedPet.setAge(petRequest.getAge());
        updatedPet.setGender(petRequest.getGender());
        updatedPet.setColor(petRequest.getColor());
        updatedPet.setBreed(breed);

        if (!Objects.equals(petRequest.getPicture().getOriginalFilename(), "")) {
            fileStorageService.delete(updatedPet.getPicture().getName());

            String fileName = Instant.now().getEpochSecond() + "_" + petRequest.getPicture().getOriginalFilename().toLowerCase();
            String fieUrl = MessageFormat.format("/statics/{0}", fileName);
            Picture picture = Picture.builder()
                .name(fileName)
                .url(fieUrl)
                .pet(updatedPet)
                .build();
            updatedPet.setPicture(picture);

            fileStorageService.save(
                petRequest.getPicture(),
                fileName
            );
        }

        return petRepository.save(updatedPet);
    }

    @Override
    public ApiResponse deletePet(Long id) {
        Pet deletedPet = this.getPet(id);

        fileStorageService.delete(deletedPet.getPicture().getName());

        petRepository.delete(deletedPet);

        return ApiResponse.builder()
            .success(Boolean.TRUE)
            .message("Pet deleted success")
            .build();
    }
}
