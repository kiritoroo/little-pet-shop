package com.trungle.littlepetshop.service;

import com.trungle.littlepetshop.model.Breed;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.BreedRequest;

import java.util.List;

public interface BreedService {
    List<Breed> getBreedsList();
    Breed getBreed(Long id);
    Breed createBreed(BreedRequest breedRequest);
    Breed updateBreed(Long id, BreedRequest breedRequest);
    ApiResponse deleteBreed(Long id);
}
