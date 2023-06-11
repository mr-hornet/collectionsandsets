package com.example.collectionsandsets.service.impl;

import com.example.collectionsandsets.exceptions.EmployeeNotFoundException;
import com.example.collectionsandsets.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.collectionsandsets.service.impl.EmployeeTestConstants.*;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturnEmployeeWithMaxSalaryByDepartment() {
        when(employeeService.findAll()).thenReturn(COLLECTION);
        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.findMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhereFindEmployeeWithMaxSalaryByDepartment() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmployeeWithMaxSalaryByOtherDepartment() {
        when(employeeService.findAll()).thenReturn(COLLECTION);
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findMaxSalary(DEPARTMENT_ID2));
    }

    @Test
    public void shouldReturnEmployeeWithMinSalaryByDepartment() {
        when(employeeService.findAll()).thenReturn(COLLECTION);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhereFindEmployeeWithMinSalaryByDepartment() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmployeeWithMinSalaryByOtherDepartment() {
        when(employeeService.findAll()).thenReturn(COLLECTION);
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findMinSalary(DEPARTMENT_ID2));
    }
    @Test
    public void shouldFindEmployeeByDepartment() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(singletonList(MAX_SALARY_EMPLOYEE), departmentService.findEmployeesByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(EMPLOYEE_DEPARTMENT_ID2), departmentService.findEmployeesByDepartment(DEPARTMENT_ID2));
    }

    @Test
    public void shouldReturnEmptyEmployeesMapByDepartment () {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertEquals(emptyMap(), departmentService.findEmployeesByDepartment());
    }
    @Test
    public void shouldReturnNotEmptyEmployeesMapByDepartment () {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(EMPLOYEES_BY_DEPARTMENTS_MAP, departmentService.findEmployeesByDepartment());
    }

}