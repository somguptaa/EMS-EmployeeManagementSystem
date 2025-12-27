package com.som.ems.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.som.ems.dto.ResponseMessageDto;
import com.som.ems.entity.Employee;
import com.som.ems.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "EmployeeController", description = "Employee CRUD Operations")
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	// CREATE
	@Operation(summary = "Create New Employee")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Employee Created Successfully"),
			@ApiResponse(responseCode = "400", description = "Employee Creation Failed") })
	@PostMapping
	public ResponseEntity<ResponseMessageDto> createNewEmployee(@Valid @RequestBody Employee employee) {

		logger.info("START: Create Employee Request Received: {}", employee);

		Employee saved = employeeService.create(employee);

		logger.info("SUCCESS: Employee Created with ID: {}", saved.getId());

		ResponseMessageDto response = new ResponseMessageDto(201, "SUCCESS", "Employee created successfully", saved);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// GET ALL
	@Operation(summary = "Get All Employees")
	@GetMapping
	public ResponseEntity<ResponseMessageDto> getAllEmployees() {

		logger.info("START: Fetching All Employees");

		List<Employee> employees = employeeService.getAll();

		logger.info("SUCCESS: {} Employees Retrieved", employees.size());

		ResponseMessageDto response = new ResponseMessageDto(200, "Employees fetched successfully", employees);

		return ResponseEntity.ok(response);
	}

	// GET BY ID
	@Operation(summary = "Get Employee By ID")
	@GetMapping("/{id}")
	public ResponseEntity<ResponseMessageDto> getEmployeeById(@PathVariable Long id) {

		logger.info("START: Fetching Employee with ID: {}", id);

		Employee employee = employeeService.getById(id);

		if (employee == null) {
			logger.error("ERROR: Employee Not Found with ID: {}", id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessageDto(404, "Employee not found"));
		}

		logger.info("SUCCESS: Employee Found with ID: {}", id);

		ResponseMessageDto response = new ResponseMessageDto(200, "SUCCESS", "Employee fetched successfully", employee);

		return ResponseEntity.ok(response);
	}

	// UPDATE
	@Operation(summary = "Update Employee")
	@PutMapping("/{id}")
	public ResponseEntity<ResponseMessageDto> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

		logger.info("START: Updating Employee with ID: {}, Updated Data: {}", id, employee);

		Employee updated = employeeService.update(id, employee);

		if (updated == null) {
			logger.error("ERROR: Cannot Update — Employee Not Found with ID: {}", id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessageDto(404, "Employee not found"));
		}

		logger.info("SUCCESS: Employee Updated with ID: {}", id);

		ResponseMessageDto response = new ResponseMessageDto(200, "SUCCESS", "Employee updated successfully", updated);

		return ResponseEntity.ok(response);
	}

	// DELETE BY ID
	@Operation(summary = "Delete Employee By ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessageDto> deleteEmployee(@PathVariable Long id) {

		logger.info("START: Deleting Employee with ID: {}", id);

		boolean deleted = employeeService.deleteById(id);

		if (!deleted) {
			logger.error("ERROR: Cannot Delete — Employee Not Found with ID: {}", id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessageDto(404, "Employee not found"));
		}

		logger.info("SUCCESS: Employee Deleted with ID: {}", id);

		ResponseMessageDto response = new ResponseMessageDto(200, "SUCCESS", "Employee deleted successfully", null);

		return ResponseEntity.ok(response);
	}

	// DELETE ALL
	@Operation(summary = "Delete All Employees")
	@DeleteMapping("/all")
	public ResponseEntity<ResponseMessageDto> deleteAllEmployees() {

		logger.warn("WARNING: Request Received to Delete ALL Employees");

		employeeService.deleteAll();

		logger.info("SUCCESS: All Employees Deleted");

		ResponseMessageDto response = new ResponseMessageDto(200, "SUCCESS", "All employees deleted successfully",
				null);

		return ResponseEntity.ok(response);
	}
}
