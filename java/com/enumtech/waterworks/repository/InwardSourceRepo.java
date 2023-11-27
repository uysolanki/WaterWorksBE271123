package com.enumtech.waterworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enumtech.waterworks.entity.InwardSource;

public interface InwardSourceRepo extends JpaRepository<InwardSource, Integer> {

	InwardSource findByInwardSname(String inwardSname);

}
