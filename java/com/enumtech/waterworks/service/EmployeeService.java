package com.enumtech.waterworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.enumtech.waterworks.entity.Employee;
import com.enumtech.waterworks.repository.EmployeeRepo;

@Validated
@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	public Employee insertEmployee(Employee employee) {

		return employeeRepo.save(employee);
	}

	public void deleteEmployeeById(long empNo) {

		employeeRepo.deleteById(empNo);
	}

	public Employee updateEmployeeById(long empNo, Employee employee) {
		Employee insertDB = null;
		Optional<Employee> temp = employeeRepo.findById(empNo);

		if (temp.isPresent()) {
			insertDB = temp.get();
			insertDB.setEmpName(employee.getEmpName());
			insertDB.setEmpMobileNo(employee.getEmpMobileNo());
			insertDB.setEmpAddress(employee.getEmpAddress());
			insertDB.setEmpSalary(employee.getEmpSalary());
			insertDB.setEmpAdharNo(employee.getEmpAdharNo());
		}
		return employeeRepo.save(insertDB);

	}

	public List<Employee> getAllEmployee() {
		
		return employeeRepo.findAll();
	}

	public Employee getEmployeeByName(String employeeName) {
		
		return employeeRepo.findByEmpName(employeeName) ;
	}

	public Employee getEmployeeByAdharNo(long employeeAdharNo) {
		
		return employeeRepo.getEmployeeByAdharNo(employeeAdharNo);
	}

	public Employee getEmployeeByMobileNo(long employeeMobileNo) {
		
		return employeeRepo.getEmployeeByMobileNo(employeeMobileNo);
	}

	public Optional<Employee> getByEmployeeNo(long empNo) {
		
		return employeeRepo.findById(empNo);
	}

	
}
