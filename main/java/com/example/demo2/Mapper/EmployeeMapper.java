package com.example.demo2.Mapper;

import com.example.demo2.Dto.EmployeeDto;
import com.example.demo2.Entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail()
        );
    }
    public static Employee mapToEmployee(EmployeeDto employeedto){
        return new Employee(
                employeedto.getId(),
                employeedto.getFirstname(),
                employeedto.getLastname(),
                employeedto.getEmail()
        );
    }
}
