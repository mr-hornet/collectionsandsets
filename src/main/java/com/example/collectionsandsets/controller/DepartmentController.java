package com.example.collectionsandsets.controller;

import com.example.collectionsandsets.model.Employee;
import com.example.collectionsandsets.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalary (@RequestParam int departmentId) {
        return departmentService.findMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalary (@RequestParam int departmentId) {
        return departmentService.findMinSalary(departmentId);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection<Employee> findAllEmployees (@RequestParam int departmentId) {
        return departmentService.findAllEmployees(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployeeByDepartment () {
        return departmentService.findEmployeesByDepartment();
    }





}
