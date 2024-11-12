package com.hibernate.mysql.crud.service;

import com.hibernate.mysql.crud.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee>getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee,Long id);
    void deleteEmployee(Long id);

}
