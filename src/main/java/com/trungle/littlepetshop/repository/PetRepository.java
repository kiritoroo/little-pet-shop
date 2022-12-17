package com.trungle.littlepetshop.repository;

import com.trungle.littlepetshop.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
