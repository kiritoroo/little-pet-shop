package com.trungle.littlepetshop.payload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PetRequest {
    @NotBlank(message = "Pet name not blank")
    @Size(max = 200)
    private String name;

    @Size(max = 200)
    private String description;

    @NotNull(message = "Pet age not null")
    private int age;

    @NotBlank(message = "Pet gender not blank")
    private String gender;

    @NotBlank(message = "Pet color not blank")
    private String color;

    @NotNull(message = "Pet breed not null")
    private Long breed;

    private MultipartFile picture;
}
