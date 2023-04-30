package com.example.spring_basics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class MethodArgumentNotValidException extends RuntimeException {
        public MethodArgumentNotValidException(String message) {
            super(message);
        }
    }


