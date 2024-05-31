package com.crewper.beta.service;

import com.crewper.beta.dto.EmployeeDTO;
import com.crewper.beta.entity.Employee;
import com.crewper.beta.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() throws Exception{
        try {
            return employeeRepository.findAll();
        } catch (Exception exception) {
            throw  new Exception(exception.getMessage());
        }
    }

    public Employee getEmployee(long id) throws Exception{
        try {
            return employeeRepository.findById(id).get();
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public Employee saveEmployee(EmployeeDTO employee) throws Exception {
        try {
            return employeeRepository.save(
                    Employee.build(
                            0,
                            employee.getName(),
                            employee.getEmail(),
                            employee.getPhoneNumber(),
                            employee.getTotalVacationBalance(),
                            employee.getRemainingVacationBalance()
                    )
            );
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
