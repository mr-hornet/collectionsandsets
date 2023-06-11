package com.example.collectionsandsets.service;

import com.example.collectionsandsets.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee findMaxSalary(int department);

    Employee findMinSalary(int department);

    Collection<Employee> findAllEmployees(int department);

    Map<Integer, List<Employee>> findEmployeesByDepartment();

    Collection<Employee> findEmployeesByDepartment(int department);
}
