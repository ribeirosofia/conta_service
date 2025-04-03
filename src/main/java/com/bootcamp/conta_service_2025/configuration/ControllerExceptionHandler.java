package com.bootcamp.conta_service_2025.configuration;

import com.bootcamp.conta_service_2025.exception.ContaExistenteException;
import com.bootcamp.conta_service_2025.exception.ContaNaoExistenteException;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.HashMap;

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

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error -> {
//            String fieldName = ((FieldError) error.getField());
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        }));
//  }


}
