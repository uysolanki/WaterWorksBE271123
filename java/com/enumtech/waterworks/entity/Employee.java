package com.enumtech.waterworks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="emp_seq")
	@SequenceGenerator(name = "emp_seq", sequenceName = "emp_seq", initialValue = 1, allocationSize=1)	
	private long empNo;
	
	@NotBlank(message = "name cannot be blank")
	private String empName;
	
	@Column(unique=true)
    private long empMobileNo;
    
    @NotBlank(message = "Employee address is required")
	private String empAddress;

	@NotNull(message = "Date of joining is required")
	private String empDOJ;
	
	@NotNull(message = "Employee salary is required")
	private long empSalary;
	
	@Column(unique=true)
	private long empAdharNo;

}
