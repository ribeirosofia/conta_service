package com.bootcamp.conta_service_2025.exception;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String message) {
      super(message);
    }
}
