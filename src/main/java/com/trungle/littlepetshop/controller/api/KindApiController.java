package com.trungle.littlepetshop.controller.api;

import com.trungle.littlepetshop.model.Kind;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.KindRequest;
import com.trungle.littlepetshop.service.KindService;
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

@Tag(name = "Pet Kind CRUD Operation")
@RestController
@RequestMapping("/api/kinds")
public class KindApiController {
    @Autowired
    private KindService kindService;

    @GetMapping
    public ResponseEntity<List<Kind>> getKindsList() {
        List<Kind> data = kindService.getKindsList();

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kind> getKind(
        @PathVariable(name = "id") long id
    ) {
        Kind data = kindService.getKind(id);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @PostMapping
    public ResponseEntity<Kind> createKind(
        @RequestBody KindRequest body
    ) {
        Kind data = kindService.createKind(body);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kind> updateKind(
        @PathVariable(name = "id") Long id,
        @RequestBody KindRequest body
    ) {
        Kind data = kindService.upateKind(id, body);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteKind(
        @PathVariable(name = "id") Long id
    ) {
        ApiResponse data = kindService.deleteKind(id);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(data);
    }
}
