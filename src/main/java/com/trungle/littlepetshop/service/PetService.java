package com.trungle.littlepetshop.service;

import com.trungle.littlepetshop.model.Pet;
import com.trungle.littlepetshop.payload.ApiResponse;

import java.util.List;

public interface PetService {
    List<Pet> getPetsList();
    Pet getPet(Long id);
    Pet createPet(Pet pet);
    Pet updatePet(Pet pet, Long id);
    ApiResponse deletePet(Long id);
}
