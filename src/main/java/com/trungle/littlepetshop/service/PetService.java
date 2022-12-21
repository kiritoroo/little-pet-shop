package com.trungle.littlepetshop.service;

import com.trungle.littlepetshop.model.Pet;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.PetRequest;

import java.util.List;

public interface PetService {
    List<Pet> getPetsList();
    Pet getPet(Long id);
    Pet createPet(PetRequest petRequest);
    Pet updatePet(Long id, PetRequest petRequest);
    ApiResponse deletePet(Long id);
}
