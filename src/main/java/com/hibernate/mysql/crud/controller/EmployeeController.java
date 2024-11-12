package com.hibernate.mysql.crud.controller;

import com.hibernate.mysql.crud.model.Employee;
import com.hibernate.mysql.crud.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }


    //create Employee REST API
    @PostMapping()
    public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
        return  new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // Get All Employees REST API
    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long  employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable("id") long id,Employee employee ){
            return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee Deleted Successfully...!",HttpStatus.OK);
    }
}
