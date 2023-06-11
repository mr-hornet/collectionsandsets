package com.example.collectionsandsets.service.impl;

import com.example.collectionsandsets.exceptions.InvalidEmployeeDataExeption;
import com.example.collectionsandsets.service.EmployeeValidationService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (StringUtils.isBlank(name) || !StringUtils.isAlpha(name)) {
            throw new InvalidEmployeeDataExeption("Неверное значение " + name);
        }
    }
}
