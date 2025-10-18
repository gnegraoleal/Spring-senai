package com.example.demo.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> IllegalArgumentException (MethodArgumentNotValidException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
            "mensagem", exception.getMessage(),
            "sucesso", false
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest().body(Map.of(
            "mensagem", exception.getFieldErrors().get(0).getDefaultMessage(),
            "sucesso", false
        ));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> runtimeException(RuntimeException exception){
        return ResponseEntity.badRequest().body(Map.of(
            "mensagem", exception.getMessage(),
            "sucesso", false
        ));
    }
}
