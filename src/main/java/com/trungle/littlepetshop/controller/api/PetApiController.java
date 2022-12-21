package com.trungle.littlepetshop.controller.api;

import com.trungle.littlepetshop.model.Pet;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.PetRequest;
import com.trungle.littlepetshop.service.PetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Pet CRUD Operation")
@RestController
@RequestMapping("/api/pets")
public class PetApiController {
    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> getPetsList() {
        List<Pet> data = petService.getPetsList();

        return  ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(
        @PathVariable(name = "id") Long id
    ) {
        Pet data = petService.getPet(id);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(
        @RequestBody PetRequest body
    ) {
        Pet data = petService.createPet(body);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(
        @PathVariable(name = "id") Long id,
        @RequestBody PetRequest body
    ) {
        Pet data = petService.updatePet(id, body);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePet(
        @PathVariable(name = "id") Long id
    ) {
        ApiResponse data = petService.deletePet(id);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }
}

