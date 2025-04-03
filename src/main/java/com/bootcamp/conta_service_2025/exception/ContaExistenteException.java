package com.bootcamp.conta_service_2025.exception;

public class ContaExistenteException extends RuntimeException {
    public ContaExistenteException(String message) {
        super(message);
    }
}
