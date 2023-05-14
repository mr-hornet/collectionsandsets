package com.example.collectionsandsets.service;

import com.example.collectionsandsets.exceptions.EmployeeAlreadyAddedException;
import com.example.collectionsandsets.exceptions.EmployeeStorageIsFullException;
import com.example.collectionsandsets.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int MAX_COUNT = 10;

    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        if (employees.size() == MAX_COUNT) {
            throw new EmployeeStorageIsFullException();
        }

        employees.add(employee);

        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.remove(employee);

        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }
}
