package com.example.employeeManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeMailAlreadyExistsException extends RuntimeException{
    public EmployeeMailAlreadyExistsException(String employeeMail ){

        super(String.format("The empMail: '%s' already exists",employeeMail));
    }

}
