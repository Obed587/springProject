package com.example.demo2.Service.Impl;

import com.example.demo2.Dto.EmployeeDto;
import com.example.demo2.Entity.Employee;
import com.example.demo2.Exception.ResourceNotFoundException;
import com.example.demo2.Mapper.EmployeeMapper;
import com.example.demo2.Repository.EmployeeRepository;
import com.example.demo2.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeid) {
        Employee employee=employeeRepository.findById(employeeid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id : " + employeeid));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeid, EmployeeDto updatedEmployee) {
        Employee employee=employeeRepository.findById(employeeid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id : " + employeeid));

        employee.setFirstname(updatedEmployee.getFirstname());
        employee.setLastname(updatedEmployee.getLastname());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void DeleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id : " + id));

        employeeRepository.deleteById(id);
    }
}
