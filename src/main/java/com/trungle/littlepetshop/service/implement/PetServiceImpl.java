package com.trungle.littlepetshop.service.implement;

import com.trungle.littlepetshop.model.Pet;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.repository.PetRepository;
import com.trungle.littlepetshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> getPetsList() {
        return null;
    }

    @Override
    public Pet getPet(Long id) {
        return null;
    }

    @Override
    public Pet createPet(Pet pet) {
        return null;
    }

    @Override
    public Pet updatePet(Pet pet, Long id) {
        return null;
    }

    @Override
    public ApiResponse deletePet(Long id) {
        return null;
    }
}
