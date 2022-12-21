package com.trungle.littlepetshop.repository;

import com.trungle.littlepetshop.model.Habitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat, Long> {
}
