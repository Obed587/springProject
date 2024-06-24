package com.example.demo2.Service;

import com.example.demo2.Dto.EmployeeDto;
import com.example.demo2.Repository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeid);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeid, EmployeeDto updatedEmployee);

    void DeleteEmployee(Long id);
}
