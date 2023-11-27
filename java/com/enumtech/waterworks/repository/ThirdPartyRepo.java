package com.enumtech.waterworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enumtech.waterworks.entity.ThirdParty;
@Repository
public interface ThirdPartyRepo extends JpaRepository<ThirdParty, Integer> {
	
	public ThirdParty findByName(String name);


}
