package com.trungle.littlepetshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@Entity @Table(name = "pet_breeds")
@JsonIgnoreProperties(
    value = {"habitats", "pets"},
    allowGetters = true
)
public class Breed extends DateAudit {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Pet breed title not blank")
    @Size(max = 200)
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Size(max = 200)
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Breed origin not blank")
    @Size(max = 200)
    @Column(name = "origin", nullable = false)
    private String origin;

    @NotNull(message = "Breed kind not null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kind", nullable = false)
    private Kind kind;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "breed_habitat",
        joinColumns = @JoinColumn(name = "id_breed", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_habitat", referencedColumnName = "id"),
        uniqueConstraints = {@UniqueConstraint(
            name = "uk_breed_habitat",
            columnNames = {"id_breed", "id_habitat"}
        )}
    )
    private List<Habitat> habitats;

    @OneToMany(
        mappedBy = "breed",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Pet> pets;
}
