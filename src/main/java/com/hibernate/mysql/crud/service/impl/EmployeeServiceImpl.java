package com.hibernate.mysql.crud.service.impl;

import com.hibernate.mysql.crud.exception.EmployeeException;
import com.hibernate.mysql.crud.model.Employee;
import com.hibernate.mysql.crud.repository.EmployeeRepository;
import com.hibernate.mysql.crud.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {



    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new EmployeeException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee existingEmployee =getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existingEmployee =getEmployeeById(id);
        employeeRepository.deleteById(id);

    }
}
