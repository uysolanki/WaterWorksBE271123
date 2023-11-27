package com.enumtech.waterworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.waterworks.entity.Attendance;
import com.enumtech.waterworks.repository.AttdRepo;

@Service
public class AttdService {
	
	@Autowired
	private AttdRepo repository;

	public Attendance registerAttd(Attendance attd) {
		
		return repository.save(attd);
	}


	public List<Attendance> getAllAttendance() {
		
		return repository.findAll();
	}

	public List<Attendance> getAttendById(long empNo) {
		
		return repository.getAttendById(empNo);
	}
    
	public List<Attendance> getAttendByMobile(String empMobileNo) {
		
		return (repository.getAttByMobile(empMobileNo));
	}

	public List<Attendance> getAttendByName(String empName) {
		
		return repository.getAttByName(empName);
	}



	

}
