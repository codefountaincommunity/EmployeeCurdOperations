package com.codefountain.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.codefountain.entities.Employee;
import com.codefountain.dto.EmployeeDTO;
import com.codefountain.services.EmployeeService;
import com.codefountain.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        Employee newEmployee =employee.dtoToEntity(employeeDTO);
        LOGGER.info("Employee created");
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = getEmployeeById(id);
        Employee updatedEmployee = existingEmployee.dtoToEntity(employeeDTO);
        LOGGER.info("Employee updated");
        return employeeRepository.save(updatedEmployee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        LOGGER.info("getEmployeeId:" + id);
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        LOGGER.info("getAll Employees");
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getAllEmployees(Pageable pageable) {
        LOGGER.info("getAll Pageable Employees");
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        LOGGER.info("delete Employee Id" + id);
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteAllEmployees() {
        LOGGER.info("delete Employees");
        employeeRepository.deleteAll();
    }
}