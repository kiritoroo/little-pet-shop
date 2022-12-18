package com.trungle.littlepetshop.controller.api;

import com.trungle.littlepetshop.model.Breed;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.BreedRequest;
import com.trungle.littlepetshop.service.BreedService;
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

@Tag(name = "Pet breed CRUD Operation")
@RestController
@RequestMapping("/api/breeds")
public class BreedApiController {
    @Autowired
    private BreedService breedService;

    @GetMapping
    public ResponseEntity<List<Breed>> getBreedsList() {
        List<Breed> data = breedService.getBreedsList();

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Breed> getBreed(
        @PathVariable(name = "id") Long id
    ) {
        Breed data = breedService.getBreed(id);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @PostMapping
    public ResponseEntity<Breed> createBreed(
        @RequestBody BreedRequest body
    ) {
        Breed data = breedService.createBreed(body);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Breed> updateBreed(
        @PathVariable(name = "id") Long id,
        @RequestBody BreedRequest body
    ) {
        Breed data = breedService.updateBreed(id, body);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteBreed(
        @PathVariable(name = "id") Long id
    ) {
        ApiResponse data = breedService.deleteBreed(id);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }
}
