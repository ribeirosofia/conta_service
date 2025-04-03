package com.bootcamp.conta_service_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotEmpty;


@Builder
@Data
@AllArgsConstructor
public class ContaRequestDTO {
    private String nomeTitular;
    private Integer numeroAgencia;

    @NotNull
    private Integer numeroConta;

    @NotEmpty
    private String chavePix;

}
