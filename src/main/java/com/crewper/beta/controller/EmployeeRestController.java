package com.crewper.beta.controller;

import com.crewper.beta.dto.EmployeeDTO;
import com.crewper.beta.entity.Employee;
import com.crewper.beta.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<Employee>> getEmployees () throws Exception {
        try {
            return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(long id) throws Exception {
        try {
            return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDTO employee) throws Exception {
        try {
            return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
