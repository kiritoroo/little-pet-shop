package com.trungle.littlepetshop.service;

import com.trungle.littlepetshop.model.Breed;
import com.trungle.littlepetshop.payload.ApiResponse;

import java.util.List;

public interface BreedService {
    List<Breed> getBreedsList();
    Breed getBreed(Long id);
    Breed createBreed(Breed breed);
    Breed updateBreed(Breed breed, Long id);
    ApiResponse deleteBreed(Long id);
}
