package com.sboot.app.springrest.services;

import com.sboot.app.springrest.exception.ResourceNotFoundException;
import com.sboot.app.springrest.model.Employee;
import com.sboot.app.springrest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository repo;

    @Override
    public Employee saveEmployee(Employee emp) {
        return repo.save(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
//        Optional<Employee> emp = repo.findById(id);
//        if(emp.isPresent()){
//            return emp.get();
//        }else{
//            throw new ResourceNotFoundException("Employee","Id",id);
//        }

        return repo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","id",id));
    }

    @Override
    public Employee updateEmployee(Employee emp, long id) {
        Employee employee = repo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "id", id));
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());
        employee.setEmail(emp.getEmail());
        repo.save(employee);

        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        Employee employee = repo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "id", id));
        repo.deleteById(id);
    }
}
