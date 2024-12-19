package com.example.employeeManagementSystem.dto;

//import jakarta.persistence.Column;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long empId;
@NotEmpty(message = "Employee name should not be empty")
    private  String empName;
    @NotEmpty(message = "Employee mail should not be empty")
    private String empEmail;
    @NotEmpty(message = "Employee location should not be empty")
    private String empLocation;
}
