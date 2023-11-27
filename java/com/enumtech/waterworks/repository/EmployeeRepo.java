package com.enumtech.waterworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enumtech.waterworks.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	Employee findByEmpName(String empName);

	@Query(value="select * from Employee where emp_adhar_no=?1",nativeQuery = true)
	Employee getEmployeeByAdharNo(long empAdharNo);

	@Query(value="select * from Employee where emp_mobile_no=?1",nativeQuery = true)
	Employee getEmployeeByMobileNo(long empMobileNo);
	

}
