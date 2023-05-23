package com.example.collectionsandsets.service;

import com.example.collectionsandsets.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();
}
