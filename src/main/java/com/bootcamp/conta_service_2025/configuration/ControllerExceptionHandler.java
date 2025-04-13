package com.bootcamp.conta_service_2025.configuration;

import com.bootcamp.conta_service_2025.exception.ContaExistenteException;
import com.bootcamp.conta_service_2025.exception.ContaNaoExistenteException;
import com.bootcamp.conta_service_2025.exception.SaldoInsuficienteException;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ContaExistenteException.class)
    private ProblemDetail exceptionContaExistente(ContaExistenteException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
        problemDetail.setTitle("Conflict");
        problemDetail.setType(URI.create("http://localhost/9000/doc/conta-existente"));
        return problemDetail;
    }

    @ExceptionHandler(ContaNaoExistenteException.class)
    private ProblemDetail exceptionContaNaoExistente(ContaNaoExistenteException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Not Found");
        problemDetail.setType(URI.create("http://localhost/9000/doc/conta-nao-existe"));
        return problemDetail;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Validation failed. Check 'errors' property for details."
        );
        problemDetail.setTitle("Validation Error");
        problemDetail.setType(URI.create("http://localhost/9000/doc/error-dto"));
        problemDetail.setProperty("errors", errors);

        return ResponseEntity.badRequest().body(problemDetail);
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    private ProblemDetail handlerSaldoInsuficiente(SaldoInsuficienteException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        problemDetail.setTitle("Saldo Insuficiente");
        problemDetail.setType(URI.create("http://localhost/9000/doc/saldo-insuficiente"));
        return problemDetail;
    }


}
