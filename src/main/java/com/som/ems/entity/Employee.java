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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "empName")
	private String empName;

	@Column(name = "empaddress")
	private String empaddress;
	
	@Column(name ="empMail")
	private String email;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name="empDept")
	private String dept;
	
	@CreationTimestamp
	@Column(name = "createdDate" ,updatable = false)
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name = "updatedDate")
	private LocalDateTime updatedDate;

}
