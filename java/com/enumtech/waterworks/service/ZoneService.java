package com.enumtech.waterworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.waterworks.entity.Zone;
import com.enumtech.waterworks.repository.ZoneRepo;
@Service
public class ZoneService {
	
	@Autowired
	ZoneRepo zoneRepo;

	public void addZone(Zone zone) {
		 zoneRepo.save(zone);
		
	}

	public List<Zone> getAllZone() {
		
	 return zoneRepo.findAll();
	}


}
