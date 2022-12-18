package com.trungle.littlepetshop.controller.api;

import com.trungle.littlepetshop.model.Habitat;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.HabitatRequest;
import com.trungle.littlepetshop.service.HabitatService;
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

@Tag(name = "Habitat CRUD Operation")
@RestController
@RequestMapping("/api/habitats")
public class HabitatApiController {
    @Autowired
    private HabitatService habitatService;

    @GetMapping
    public ResponseEntity<List<Habitat>> getHabitatsList() {
        List<Habitat> data = habitatService.getHabitatsList();

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitat> getHabitat(
        @PathVariable(name = "id") Long id
    ) {
        Habitat data = habitatService.getHabitat(id);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @PostMapping
    public ResponseEntity<Habitat> createHabitat(
        @RequestBody HabitatRequest body
    ) {
        Habitat data = habitatService.createHabitat(body);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitat> updateHabitat(
        @PathVariable(name = "id") Long id,
        @RequestBody HabitatRequest body
    ) {
        Habitat data = habitatService.updateHabitat(id, body);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteHabitat(
        @PathVariable(name = "id") Long id
    ) {
        ApiResponse data = habitatService.deleteHabitat(id);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }
}
