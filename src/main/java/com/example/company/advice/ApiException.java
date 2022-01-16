package com.example.company.advice;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception{

    private HttpStatus status;

    public ApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
