package com.example.spring_basics.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class MethodArgumentNotValidAdvice {

 @ExceptionHandler({MethodArgumentNotValidException.class})

    public Map<String, String> Missingparameters(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap1 = new HashMap<>();
        errorMap1.put("errorMessage", exception.getMessage());

        return errorMap1;
    }
}