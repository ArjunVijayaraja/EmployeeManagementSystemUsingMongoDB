package com.example.employeeManagementSystem.entity;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.annotation.processing.Generated;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "employees")
@Document(collection = "employees")
public class Employee {

    @Transient
    public static final String SEQUENCE_NAME = "employee_sequence";


    @Id
    private long empId;
    private  String empName;
    private String empEmail;
    private String empLocation;
}
