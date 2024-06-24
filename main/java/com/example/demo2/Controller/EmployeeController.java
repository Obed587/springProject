package com.example.demo2.Controller;

import com.example.demo2.Dto.EmployeeDto;
import com.example.demo2.Entity.Employee;
import com.example.demo2.Repository.EmployeeRepository;
import com.example.demo2.Service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {


    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeedto){
        employeeService.createEmployee(employeedto);
        return new ResponseEntity<>(employeedto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDto employeedto=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeedto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees=employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{Id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("Id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
       EmployeeDto employeedto=employeeService.updateEmployee(employeeId, updatedEmployee);
       return ResponseEntity.ok(employeedto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.DeleteEmployee(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
