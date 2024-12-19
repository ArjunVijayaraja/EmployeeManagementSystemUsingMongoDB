package com.example.employeeManagementSystem.repository;

import com.example.employeeManagementSystem.dto.EmployeeDto;
import com.example.employeeManagementSystem.entity.Employee;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//
//    Optional<Employee> findByEmpEmail(String employeeMail);
//}


public interface EmployeeRepository extends MongoRepository<Employee, Long> {

    Optional<Employee> findByEmpEmail(String employeeMail);
}
