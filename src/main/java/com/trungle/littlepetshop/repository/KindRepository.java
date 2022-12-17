package com.trungle.littlepetshop.repository;

import com.trungle.littlepetshop.model.Kind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KindRepository extends JpaRepository<Kind,Long> {
}
