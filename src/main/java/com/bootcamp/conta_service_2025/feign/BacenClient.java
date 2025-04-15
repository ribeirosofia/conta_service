package com.bootcamp.conta_service_2025.feign;

import com.bootcamp.conta_service_2025.feign.dto.ChaveRequestDTO;
import com.bootcamp.conta_service_2025.feign.dto.ChaveResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        contextId = "BacenClient",
        name = "bacen-service",
        url = "http://localhost:9002"
)
public interface BacenClient {
    @PostMapping("/api/bacen/chaves")
    ChaveResponseDTO criarChave(@RequestBody ChaveRequestDTO chaveRequestDTO);

    @GetMapping(value = "/api/bacen/chaves/{chave}")
    ChaveResponseDTO buscaChave(@PathVariable final String chave);
}
