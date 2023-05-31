package com.example.collectionsandsets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmployeeDataExeption extends RuntimeException {
    public InvalidEmployeeDataExeption(String message) {
        super(message);
    }
}
