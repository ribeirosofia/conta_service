package com.bootcamp.conta_service_2025.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class PixRequestDTO {

    @NotEmpty
    private String chavePixPagador;
    @NotEmpty
    private String chavePixRecebedor;
    @NotNull
    private BigDecimal valor;
    @NotEmpty
    private String idempotencia;


}
