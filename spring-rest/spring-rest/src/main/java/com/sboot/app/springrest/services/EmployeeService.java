package com.sboot.app.springrest.services;

import com.sboot.app.springrest.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee emp);
    List<Employee>getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee emp, long id);
    void deleteEmployeeById(long id);
}
