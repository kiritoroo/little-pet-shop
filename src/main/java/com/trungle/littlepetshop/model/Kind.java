package com.trungle.littlepetshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "pet_kinds")
@JsonIgnoreProperties(
    value = {"breeds"},
    allowGetters = true
)
public class Kind extends DateAudit {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Pet kind title not blank")
    @Size(max = 200)
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Size(max = 200)
    @Column(name = "description")
    private String description;

    @OneToMany(
        mappedBy = "kind",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Breed> breeds;
}
