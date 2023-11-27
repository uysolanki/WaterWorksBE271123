package com.enumtech.waterworks.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enumtech.waterworks.entity.Zone;
@Repository
public interface ZoneRepo extends JpaRepository<Zone, Integer> {
	

}
