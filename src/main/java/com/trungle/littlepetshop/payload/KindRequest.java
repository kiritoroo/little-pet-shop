package com.trungle.littlepetshop.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class KindRequest {
    @NotBlank(message = "Pet kind title not blank")
    @Size(max = 200)
    private String title;

    @Size(max = 200)
    private String description;
}
