package com.example.employeeManagementSystem.controller;

import com.example.employeeManagementSystem.dto.EmployeeDto;
import com.example.employeeManagementSystem.exception.EmployeeMailAlreadyExistsException;
import com.example.employeeManagementSystem.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;


    @GetMapping("/")
    public String loadHomePage() {
        return "homePage";
    }


    @GetMapping("/createEmp")
    public String loadAddEmpPage(Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employee_dto",employeeDto);
        return "AddEmployee";
    }


    @PostMapping("/createEmp/save")
    public String saveProduct(@Valid @ModelAttribute ("employee_dto") EmployeeDto employeeDto,
                              BindingResult result,
                              Model model){

        if (result.hasErrors()) {
            model.addAttribute("employee_dto", employeeDto);
            return "/AddEmployee";
        }

        try {
            employeeService.createEmployee(employeeDto);
            return "redirect:/createEmp?success";
        } catch (EmployeeMailAlreadyExistsException ex) {
            model.addAttribute("employee_dto", employeeDto); // Add product DTO to keep the filled form
            model.addAttribute("errorMessage", "Employee EXISTS ALREADY"); // Pass the error message

            return "/AddEmployee";  // Redirect back to the form page with the error message
        }
    }


//    @GetMapping("/employees")
//    public ResponseEntity<List<EmployeeDto>> displayAllEMployees(){
//
//        List<EmployeeDto> empLst = employeeService.findAllEmployees();
//        return  new ResponseEntity<List<EmployeeDto>>( empLst,HttpStatus.OK);
//    }


    @GetMapping("/viewEmployee")
    public String loadViewProdPage(Model model){
        List<EmployeeDto> employees = employeeService.findAllEmployees();
        model.addAttribute("employees",employees);
        return "viewEmployees";
    }


}
