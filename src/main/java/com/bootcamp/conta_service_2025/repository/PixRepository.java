package com.bootcamp.conta_service_2025.repository;

import com.bootcamp.conta_service_2025.model.Pix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PixRepository extends JpaRepository<Pix, UUID> {


}
