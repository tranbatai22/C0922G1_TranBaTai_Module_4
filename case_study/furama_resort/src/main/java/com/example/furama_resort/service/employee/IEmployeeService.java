package com.example.furama_resort.service.employee;

import com.example.furama_resort.dto.EmployeeDto;
import com.example.furama_resort.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);
}
