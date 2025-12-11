package com.som.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.som.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
