package com.example.employeeManagementSystem.service;

import com.example.employeeManagementSystem.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAllEmployees();
    EmployeeDto createEmployee(EmployeeDto employeeDto);
}
