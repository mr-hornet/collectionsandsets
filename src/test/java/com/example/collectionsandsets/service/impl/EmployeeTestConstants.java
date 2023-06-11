package com.example.collectionsandsets.service.impl;

import com.example.collectionsandsets.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeTestConstants {
    public static final String FIRST_NAME1 = "David";
    public static final String LAST_NAME1 = "Bakham";
    public static final String FIRST_NAME2 = "Paul";
    public static final String LAST_NAME2 = "Mackein";

    public static final int SALARY = 100;
    public static final int MAX_SALARY = 1000;
    public static final int DEPARTMENT_ID = 1;
    public static final int DEPARTMENT_ID2 = 2;
    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME1, LAST_NAME1, MAX_SALARY, DEPARTMENT_ID);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME2, LAST_NAME2, SALARY, DEPARTMENT_ID);
    public static final Employee EMPLOYEE_DEPARTMENT_ID2 = new Employee(FIRST_NAME2, LAST_NAME2, SALARY, DEPARTMENT_ID2);

    public static final List<Employee> COLLECTION = List.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE);
    public static final List<Employee> DIFFERENT_DEPARTMENT_EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, EMPLOYEE_DEPARTMENT_ID2);
    public static final Map<Integer, List<Employee>> EMPLOYEES_BY_DEPARTMENTS_MAP = DIFFERENT_DEPARTMENT_EMPLOYEES.stream()
            .collect(groupingBy(Employee::getDepartmentId));


}
