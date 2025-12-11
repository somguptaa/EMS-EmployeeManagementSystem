package com.som.ems.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.som.ems.entity.Employee;
import com.som.ems.exceptions.*;
import com.som.ems.repository.EmployeeRepository;
import com.som.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	// CREATE -------------------------------------------------------
	@Override
	public Employee create(Employee employee) {
		logger.info("Saving new employee: {}", employee);
		Employee saved = employeeRepository.save(employee);
		logger.info("Employee saved successfully with ID: {}", saved.getId());
		return saved;
	}

	// GET ALL ------------------------------------------------------
	@Override
	public List<Employee> getAll() {
		logger.info("Fetching all employees");
		List<Employee> employees = employeeRepository.findAll();
		logger.info("Fetched {} employees", employees.size());
		return employees;
	}

	// GET BY ID ----------------------------------------------------
	@Override
	public Employee getById(Long id) {
		logger.info("Fetching employee by ID: {}", id);

		return employeeRepository.findById(id).orElseThrow(() -> {
			logger.error("Employee not found with ID: {}", id);
			return new EmployeeIdNotFoundException("Employee not found with ID: " + id);
		});
	}

	// UPDATE -------------------------------------------------------
	@Override
	public Employee update(Long id, Employee employee) {

	    logger.info("Updating employee ID: {}", id);

	    Employee existing = employeeRepository.findById(id)
	            .orElseThrow(() -> new EmployeeIdNotFoundException("Employee not found with ID: " + id));

	    // FULL UPDATE → Replace all fields
	    employee.setId(existing.getId()); // keep same ID  
	    Employee updated = employeeRepository.save(employee);

	    logger.info("FULL UPDATE successful for ID: {}", id);

	    return updated;
	}


	// DELETE BY ID -------------------------------------------------
	@Override
	public boolean deleteById(Long id) {
		logger.info("Deleting employee ID: {}", id);

		if (!employeeRepository.existsById(id)) {
			logger.error("Cannot delete — employee not found with ID: {}", id);
			throw new EmployeeIdNotFoundException("Employee not found with ID: " + id);
		}

		employeeRepository.deleteById(id);
		logger.info("Employee deleted successfully with ID: {}", id);
		return true;
	}

	// DELETE ALL ---------------------------------------------------
	@Override
	public void deleteAll() {
		logger.warn("Deleting ALL employees from database");
		employeeRepository.deleteAll();
		logger.info("All employees deleted successfully");
	}
}
