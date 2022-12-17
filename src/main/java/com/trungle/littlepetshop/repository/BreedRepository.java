package com.trungle.littlepetshop.repository;

import com.trungle.littlepetshop.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breed, Long> {
}
