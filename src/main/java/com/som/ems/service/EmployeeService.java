package com.som.ems.service;

import java.util.List;
import com.som.ems.entity.Employee;


public interface EmployeeService {
	
	public Employee create(Employee employee);

	public Employee getById(Long id);

	public Employee update(Long id, Employee employee);

	public boolean deleteById(Long id);

	public List<Employee> getAll();

	public void deleteAll();
	

}
