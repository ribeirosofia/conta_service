package com.bootcamp.conta_service_2025.feign;

import com.bootcamp.conta_service_2025.exception.ErroIntegracaoBacenException;
import com.bootcamp.conta_service_2025.feign.dto.ChaveRequestDTO;
import com.bootcamp.conta_service_2025.feign.dto.ChaveResponseDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@RequiredArgsConstructor
@Slf4j
public class BacenService {
    private final BacenClient bacenClient;

    public ChaveResponseDTO criarChave(final String chave){
        try{
            log.info("Attempting to create key in BACEN: {}", chave);
            ChaveRequestDTO chaveRequestDTO = ChaveRequestDTO.builder()
                    .chave(chave)
                    .ativa(Boolean.TRUE)
                    .build();
            ChaveResponseDTO response = bacenClient.criarChave(chaveRequestDTO);
            log.info("BACEN response for key creation: {}", response);
            return response;
        } catch (Exception ex){
            log.error("Error calling BACEN API to create key: {}", chave, ex);
            throw new ErroIntegracaoBacenException("Error registering key with BACEN");
        }
    }

    public ChaveResponseDTO buscaChave(final String chave){
        try{
            log.info("Attempting to find key in BACEN: {}", chave);
            ChaveResponseDTO response = bacenClient.buscaChave(chave);
            log.info("BACEN response for key search: {}", response);
            return response;
        }catch (Exception ex){
            log.error("Error calling BACEN API to find key: {}", chave, ex);
            throw new ErroIntegracaoBacenException("Error searching key with BACEN");
        }
    }
}
