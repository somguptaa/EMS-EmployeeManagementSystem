package com.som.ems.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "empName", nullable = false)
	private String empName;

	@Column(name = "empaddress")
	private String empaddress;

	@NotNull
<<<<<<< HEAD
	@Column(name = "empMail", nullable = false)
=======
	@Column(name ="empMail", nullable = false)
>>>>>>> branch 'main' of https://github.com/somguptaa/EMS-EmployeeManagementSystem.git
	private String email;

	@Column(name = "salary")
	private double salary;

	@NotNull
<<<<<<< HEAD
	@Column(name = "empDept", nullable = false)
=======
	@Column(name="empDept", nullable = false)
>>>>>>> branch 'main' of https://github.com/somguptaa/EMS-EmployeeManagementSystem.git
	private String dept;

	@CreationTimestamp
	@Column(name = "createdDate", updatable = false)
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "updatedDate")
	private LocalDateTime updatedDate;

}
