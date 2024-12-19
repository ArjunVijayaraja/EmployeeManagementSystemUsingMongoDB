package com.example.employeeManagementSystem.service.Impl;

import com.example.employeeManagementSystem.dto.EmployeeDto;
import com.example.employeeManagementSystem.entity.DatabaseSequence;
import com.example.employeeManagementSystem.entity.Employee;
import com.example.employeeManagementSystem.exception.EmployeeMailAlreadyExistsException;
import com.example.employeeManagementSystem.repository.EmployeeRepository;
import com.example.employeeManagementSystem.repository.DatabaseSequenceRepository;
import com.example.employeeManagementSystem.service.EmployeeService;
import com.example.employeeManagementSystem.service.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DatabaseSequenceRepository sequenceRepositoryRepository;
    private SequenceGeneratorService sequenceGeneratorService;
    private ModelMapper modelMapper;


    @Override
    public List<EmployeeDto> findAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = employeeList.stream().map(emp->modelMapper.map(emp,EmployeeDto.class)).collect(Collectors.toList());
        return employeeDtoList;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmp = employeeRepository.findByEmpEmail(employeeDto.getEmpEmail());
        if(optionalEmp.isPresent()){
            throw new EmployeeMailAlreadyExistsException(employeeDto.getEmpEmail());
        }
        employeeDto.setEmpId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
         Employee emp = modelMapper.map(employeeDto,Employee.class);

        Employee savedEmp= employeeRepository.save(emp);
        return modelMapper.map(savedEmp,EmployeeDto.class);
    }
}
