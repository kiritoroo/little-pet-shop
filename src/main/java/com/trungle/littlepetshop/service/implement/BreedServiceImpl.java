package com.trungle.littlepetshop.service.implement;

import com.trungle.littlepetshop.model.Breed;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.repository.BreedRepository;
import com.trungle.littlepetshop.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedServiceImpl implements BreedService {
    @Autowired
    private BreedRepository breedRepository;

    @Override
    public List<Breed> getBreedsList() {
        return null;
    }

    @Override
    public Breed getBreed(Long id) {
        return null;
    }

    @Override
    public Breed createBreed(Breed breed) {
        return null;
    }

    @Override
    public Breed updateBreed(Breed breed, Long id) {
        return null;
    }

    @Override
    public ApiResponse deleteBreed(Long id) {
        return null;
    }
}
