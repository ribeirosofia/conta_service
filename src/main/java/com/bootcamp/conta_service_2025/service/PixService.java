package com.bootcamp.conta_service_2025.service;

import com.bootcamp.conta_service_2025.dto.PixDTO;
import com.bootcamp.conta_service_2025.dto.PixRequestDTO;
import com.bootcamp.conta_service_2025.dto.PixResponseDTO;
import com.bootcamp.conta_service_2025.exception.ContaNaoExistenteException;
import com.bootcamp.conta_service_2025.exception.SaldoInsuficienteException;
import com.bootcamp.conta_service_2025.feign.BacenService;
import com.bootcamp.conta_service_2025.model.Conta;
import com.bootcamp.conta_service_2025.model.Pix;
import com.bootcamp.conta_service_2025.repository.ContaRepository;
import com.bootcamp.conta_service_2025.repository.PixRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PixService {

    private final PixRepository pixRepository;
    private final ContaRepository contaRepository;
    private final BacenService bacenService;


    @Transactional
    public PixResponseDTO realizaPix(PixRequestDTO pixRequestDTO){

        if (pixRequestDTO.getValor().compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("Não é permitido fazer pix com valor menor que R$ 0,01.");
        }

        Optional<Pix> existingPix = pixRepository.findByIdempotencia(pixRequestDTO.getIdempotencia());

        if (existingPix.isPresent()){
            return new PixResponseDTO(
                    existingPix.get().getCreatedAt(),
                    "Pix já processado com sucesso (idempotente).",
                    existingPix.map(this::entityToDTO).get()
            );

        }
            String chavePagador = bacenService.buscaChave(pixRequestDTO.getChavePixPagador()).getChave();

        Optional<Conta> contaPagadorOptional = contaRepository.findByChavePix(chavePagador);

        if(contaPagadorOptional.isEmpty()){
            throw new ContaNaoExistenteException(String.format("Conta com a chave %s não existe.", pixRequestDTO.getChavePixPagador()));
        }

        String chaveRecebedor = bacenService.buscaChave(pixRequestDTO.getChavePixRecebedor()).getChave();

        Optional<Conta> contaRecebedorOptional = contaRepository.findByChavePix(chaveRecebedor);

        if(contaRecebedorOptional.isEmpty()){
            throw new ContaNaoExistenteException(String.format("Conta com a chave %s não existe.", pixRequestDTO.getChavePixRecebedor()));
        }

        Conta contaPagador = contaPagadorOptional.get();
        Conta contaRecebedor = contaRecebedorOptional.get();

        if(pixRequestDTO.getValor().compareTo(contaPagador.getSaldo()) > 0){
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o Pix.");
        }

        contaPagador.sacar(pixRequestDTO.getValor());
        contaRecebedor.depositar(pixRequestDTO.getValor());

        contaRepository.save(contaPagador);
        contaRepository.save(contaRecebedor);

        Pix pix = Pix.builder()
                .chavePixPagador(pixRequestDTO.getChavePixPagador())
                .chavePixRecebedor(pixRequestDTO.getChavePixRecebedor())
                .conta(contaPagador)
                .valor(pixRequestDTO.getValor())
                .idempotencia(pixRequestDTO.getIdempotencia())
                .createdAt(LocalDateTime.now())
                .build();

        pixRepository.save(pix);

        return PixResponseDTO.builder()
                .pix(entityToDTO(pix))
                .createdAt(pix.getCreatedAt())
                .message("Pix realizado com sucesso.")
                .build();
    }

    private PixDTO entityToDTO(Pix pix){
        return PixDTO.builder()
                .id(pix.getId())
                .chavePixPagador(pix.getChavePixPagador())
                .chavePixRecebedor(pix.getChavePixRecebedor())
                .valor(pix.getValor())
                .createadAt(pix.getCreatedAt())
                .idempotencia(pix.getIdempotencia())
                .build();
    }
}
