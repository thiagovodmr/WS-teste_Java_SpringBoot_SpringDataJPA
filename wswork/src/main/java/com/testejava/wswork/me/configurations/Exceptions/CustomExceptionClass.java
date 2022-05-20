package com.testejava.wswork.me.configurations.Exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionClass extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        String message = "Erro";
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        DefaultException exception = new DefaultException(HttpStatus.BAD_REQUEST.value(), message, details);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "Erro de Validação";
        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }

        DefaultException exception = new DefaultException(HttpStatus.BAD_REQUEST.value(), message, details);
        return new ResponseEntity<>(exception, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
