package com.example.collectionsandsets.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Штат сотрудников переполнен");
    }
}
