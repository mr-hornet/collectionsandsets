package com.example.collectionsandsets.service.impl;

import com.example.collectionsandsets.exceptions.*;
import com.example.collectionsandsets.model.Employee;
import com.example.collectionsandsets.service.EmployeeValidationService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static com.example.collectionsandsets.service.impl.EmployeeTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceImplTest {

    private final EmployeeValidationServiceImpl validationService = new EmployeeValidationServiceImpl();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(validationService);

    @Test
    public void shouldAddEmployee() {
        Employee employee = new Employee(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        assertFalse(employeeService.findAll().contains(employee));
        assertEquals(0, employeeService.findAll().size());

        Employee addedEmployee = employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        assertEquals(employee, addedEmployee);
        assertEquals(1, employeeService.findAll().size());
        assertTrue(employeeService.findAll().contains(employee));
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedException() {
        Employee employee = employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        assertTrue(employeeService.findAll().contains(employee));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID));
    }

    @Test
    public void shouldFindExistEmployee() {
        Employee employee = employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        assertEquals(employee, employeeService.find(FIRST_NAME1, LAST_NAME1));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployee() {
        assertEquals(0, employeeService.findAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.find(FIRST_NAME1, LAST_NAME2));
    }

    @Test
    public void shouldRemoveExistsEmployee() {
        Employee employee = employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        assertEquals(1, employeeService.findAll().size());
        assertTrue(employeeService.findAll().contains(employee));

        Employee removeEmployee = employeeService.remove(FIRST_NAME1, LAST_NAME1);
        assertEquals(employee, removeEmployee);
        assertEquals(0, employeeService.findAll().size());
        assertFalse(employeeService.findAll().contains(employee));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemoveEmployee() {
        assertEquals(0, employeeService.findAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.remove(FIRST_NAME1, LAST_NAME2));
    }

    @Test
    public void shouldReturnAllEmployees() {
        Employee employee1 = employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        Employee employee2 = employeeService.add(FIRST_NAME2, LAST_NAME2, SALARY, DEPARTMENT_ID);

        Collection<Employee> collection = employeeService.findAll();
        assertIterableEquals(List.of(employee1, employee2), collection);
    }


}