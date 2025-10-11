package com.example.aula.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> IllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("mensagem", e.getMessage()));
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> RuntimeException(RuntimeException e){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("mensagem", e.getMessage()));
    }

}
