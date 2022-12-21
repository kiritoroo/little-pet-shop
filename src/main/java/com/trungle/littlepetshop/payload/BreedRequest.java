package com.trungle.littlepetshop.payload;

import com.trungle.littlepetshop.model.Habitat;
import com.trungle.littlepetshop.model.Kind;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class BreedRequest {
    @NotBlank(message = "Pet breed title not blank")
    @Size(max = 200)
    private String title;

    @Size(max = 200)
    private String description;

    @NotBlank(message = "Breed origin not blank")
    @Size(max = 200)
    private String origin;

    @NotNull(message = "Breed kind not null")
    private Long kind;

    private List<Long> habitats;
}
