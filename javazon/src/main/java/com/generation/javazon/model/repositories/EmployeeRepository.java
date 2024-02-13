package com.generation.javazon.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.javazon.model.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
