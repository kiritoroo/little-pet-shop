package com.trungle.littlepetshop.service.implement;

import com.trungle.littlepetshop.exception.ResourceNotFoundException;
import com.trungle.littlepetshop.model.Breed;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.BreedRequest;
import com.trungle.littlepetshop.repository.BreedRepository;
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
    private PetRepository petRepository;

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
        Breed newBreed = Breed.builder()
            .title(breedRequest.getTitle())
            .description(breedRequest.getDesciption())
            .origin(breedRequest.getOrigin())
            .kind(breedRequest.getKind())
            .habitats(breedRequest.getHabitats())
            .build();

        return breedRepository.save(newBreed);
    }

    @Override
    public Breed updateBreed(Long id, BreedRequest breedRequest) {
        Breed updatedBreed = this.getBreed(id);

        updatedBreed.setTitle(updatedBreed.getTitle());
        updatedBreed.setDescription(updatedBreed.getDescription());
        updatedBreed.setOrigin(updatedBreed.getOrigin());
        updatedBreed.setKind(updatedBreed.getKind());
        updatedBreed.setHabitats(updatedBreed.getHabitats());

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
