package com.sboot.app.springrest.repository;

import com.sboot.app.springrest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
