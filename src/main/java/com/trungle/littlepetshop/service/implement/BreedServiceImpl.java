package com.trungle.littlepetshop.service.implement;

import com.trungle.littlepetshop.exception.ResourceNotFoundException;
import com.trungle.littlepetshop.model.Breed;
import com.trungle.littlepetshop.model.Habitat;
import com.trungle.littlepetshop.model.Kind;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.BreedRequest;
import com.trungle.littlepetshop.repository.BreedRepository;
import com.trungle.littlepetshop.repository.HabitatRepository;
import com.trungle.littlepetshop.repository.KindRepository;
import com.trungle.littlepetshop.repository.PetRepository;
import com.trungle.littlepetshop.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedServiceImpl implements BreedService {
    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private KindRepository kindRepository;

    @Autowired
    private HabitatRepository habitatRepository;

    @Override
    public List<Breed> getBreedsList() {
        return breedRepository.findAll();
    }

    @Override
    public Breed getBreed(Long id) {
        return breedRepository
            .findById(id)
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Breed")
                    .fieldName("ID")
                    .fieldValue(id)
                    .build()
            );
    }

    @Override
    public Breed createBreed(BreedRequest breedRequest) {
        Kind kind = kindRepository
            .findById(breedRequest.getKind())
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Kind")
                    .fieldName("ID")
                    .fieldValue(breedRequest.getKind())
                    .build()
            );

        List<Habitat> habitats = habitatRepository
            .findAllById(breedRequest.getHabitats());

        Breed newBreed = Breed.builder()
            .title(breedRequest.getTitle())
            .description(breedRequest.getDescription())
            .origin(breedRequest.getOrigin())
            .kind(kind)
            .habitats(habitats)
            .build();

        return breedRepository.save(newBreed);
    }

    @Override
    public Breed updateBreed(Long id, BreedRequest breedRequest) {
        Breed updatedBreed = this.getBreed(id);

        Kind kind = kindRepository
            .findById(breedRequest.getKind())
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Kind")
                    .fieldName("ID")
                    .fieldValue(breedRequest.getHabitats())
                    .build()
            );

        List<Habitat> habitats = habitatRepository
            .findAllById(breedRequest.getHabitats());

        updatedBreed.setTitle(breedRequest.getTitle());
        updatedBreed.setDescription(breedRequest.getDescription());
        updatedBreed.setOrigin(breedRequest.getOrigin());
        updatedBreed.setKind(kind);
        updatedBreed.setHabitats(habitats);

        return breedRepository.save(updatedBreed);
    }

    @Override
    public ApiResponse deleteBreed(Long id) {
        Breed deletedBreed = this.getBreed(id);

        breedRepository.delete(deletedBreed);

        return ApiResponse.builder()
            .success(Boolean.TRUE)
            .message("Pet breed deleted success")
            .build();
    }
}
