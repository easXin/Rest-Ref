package com.sboot.app.springrest.controller;

import com.sboot.app.springrest.model.Employee;
import com.sboot.app.springrest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmpController {

    @Autowired
    private EmployeeService service;

    @PostMapping  // generate a response after save a new emp
    public ResponseEntity<Employee> saveEmp(@RequestBody Employee emp){
        // allows us to retrieve the requestbody and automatically convert it to java object
        return new ResponseEntity<Employee>(service.saveEmployee(emp), HttpStatus.CREATED);
    }

    // http://localhost:8080/api/employees/
    @GetMapping
    public List<Employee> getAllEmps(){
        return service.getAllEmployees();
    }

    // http://localhost:8080/api/employees/3
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable(name="id") long id){
        return new ResponseEntity<Employee>(service.getEmployeeById(id), HttpStatus.OK);
    }

    // update employee with rest api
    // http://localhost:8080/api/employees/2
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmpById(@RequestBody Employee emp, @PathVariable(name="id") long id){
        return new ResponseEntity<Employee>(service.updateEmployee(emp,id), HttpStatus.OK);
    }

    // delete emp by id
    // http://localhost:8080/api/employees/2
    @DeleteMapping("{id}")
    public ResponseEntity<String> removeEmpById(@PathVariable(name="id") long id){
        service.deleteEmployeeById(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }
}
