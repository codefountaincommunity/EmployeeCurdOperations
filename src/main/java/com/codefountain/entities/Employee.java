package com.codefountain.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.codefountain.dto.EmployeeDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "mobileNumber")
    private Long mobileNumber;
    @Column(name = "accountNumber")
    private Long accountNumber;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "email")
    private String email;

    public Employee dtoToEntity(EmployeeDTO employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setMobileNumber(employeeDto.getMobileNumber());
        employee.setAccountNumber(employeeDto.getAccountNumber());
        employee.setSalary(employeeDto.getSalary());
        employee.setEmail(employeeDto.getEmail());
        return employee;



    }


}