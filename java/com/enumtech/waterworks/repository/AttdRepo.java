package com.enumtech.waterworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enumtech.waterworks.entity.Attendance;

@Repository
public interface AttdRepo extends JpaRepository<Attendance, Integer>{
	
	@Query(value="select * from attendance where emp_no=?1",nativeQuery = true)
	List<Attendance> getAttendById(long empNo);
	
	@Query(value="select * from attendance,employee where attendance.emp_no=employee.emp_no and employee.emp_mobile_no=?1",nativeQuery = true)
	List<Attendance> getAttByMobile(String empMobileNo);

	@Query(value = "select * from attendance,employee where attendance.emp_no=employee.emp_no and employee.emp_name=?1",nativeQuery = true)
	List<Attendance> getAttByName(String empName);


	

}
