package com.trungle.littlepetshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "pets")
public class Pet extends DateAudit {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Pet name not blank")
    @Size(max = 200)
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Size(max = 200)
    @Column(name = "description")
    private String description;

    @NotNull(message = "Pet age not null")
    @Column(name = "age", nullable = false)
    private int age;

    @NotBlank(message = "Pet gender not blank")
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotBlank(message = "Pet color not blank")
    @Column(name = "color", nullable = false)
    private String color;

    @NotNull(message = "Pet breed not null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_breed", nullable = false)
    private Breed breed;

    @OneToOne(
        mappedBy = "pet",
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER,
        orphanRemoval = true
    )
    @PrimaryKeyJoinColumn
    private Picture picture;
}
