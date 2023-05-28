package com.codefountain.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.codefountain.entities.Employee;
import com.codefountain.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    public Employee createEmployee(EmployeeDTO employeeDTO);

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO);

    public Employee getEmployeeById(Long id);

    public List<Employee> getAllEmployees();

    public Page<Employee> getAllEmployees(Pageable pageable);

    public void deleteEmployee(Long id);

    public void deleteAllEmployees();

}