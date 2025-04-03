package com.bootcamp.conta_service_2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.conta_service_2025.model.Conta;

import java.util.Optional;
import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {
    Optional<Conta> findByChavePix(String chavePixPagador);
    Optional<Conta> findByNomeTitularAndNumeroContaAndChavePix(String nomeTitular, Integer numeroConta, String chavePix);


}
