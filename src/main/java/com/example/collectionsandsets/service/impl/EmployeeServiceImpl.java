package com.example.collectionsandsets.service.impl;

import com.example.collectionsandsets.exceptions.EmployeeAlreadyAddedException;
import com.example.collectionsandsets.model.Employee;
import com.example.collectionsandsets.service.EmployeeService;
import com.example.collectionsandsets.service.EmployeeValidationService;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;
    private final EmployeeValidationService employeeValidationService;

    public EmployeeServiceImpl(EmployeeValidationService employeeValidationService) {
        this.employeeValidationService = employeeValidationService;
        this.employees = new HashMap<>();
        add("Ken", "Wood");
        add("Stiven", "Broke");
        add("Pum", "Boob");
        add("Mark", "Wrer");
    }

    @Override
    public Employee add(String firstName, String lastName) {
        employeeValidationService.validate(firstName, lastName);
        Employee employee = new Employee(capitalize(firstName), capitalize(lastName));

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.put(employee.getFullName(), employee);

        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.remove(employee.getFullName());

        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}
