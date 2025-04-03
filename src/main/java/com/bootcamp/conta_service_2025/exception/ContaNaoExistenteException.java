package com.bootcamp.conta_service_2025.exception;

public class ContaNaoExistenteException extends RuntimeException {
  public ContaNaoExistenteException(String message) {
    super(message);
  }
}
