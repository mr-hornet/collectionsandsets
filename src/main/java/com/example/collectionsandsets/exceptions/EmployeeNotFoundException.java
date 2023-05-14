package com.example.collectionsandsets.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("Такой сотрудник не найден");
    }
}
