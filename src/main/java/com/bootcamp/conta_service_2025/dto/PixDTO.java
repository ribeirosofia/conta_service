package com.bootcamp.conta_service_2025.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter

public class PixDTO {
    private UUID id;
    private LocalDateTime createadAt;
    private String chavePixPagador;
    private String chavePixRecebedor;
    private BigDecimal valor;
    private String idempotencia;

}
