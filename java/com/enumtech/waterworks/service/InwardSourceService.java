package com.enumtech.waterworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.waterworks.entity.InwardSource;
import com.enumtech.waterworks.repository.InwardSourceRepo;

@Service
public class InwardSourceService {

	@Autowired
	InwardSourceRepo inwardsourceRepo;

	public InwardSource addInwardSource(InwardSource inwardSource) {

		return inwardsourceRepo.save(inwardSource);
	}

	public List<InwardSource> getAllInwardSource() {

		return inwardsourceRepo.findAll();
	}

	public Optional<InwardSource> getByIdInwardSource(int inwardSid) {

		return inwardsourceRepo.findById(inwardSid);
	}

	public InwardSource updateInwardSourceById(int inwardSid, InwardSource isuser) {

		Optional<InwardSource> temp = inwardsourceRepo.findById(inwardSid);
		InwardSource inwardsodb = null;
		if (temp.isPresent()) {
			inwardsodb = temp.get();
			inwardsodb.setInwardSname(isuser.getInwardSname());

		}
		return inwardsourceRepo.save(inwardsodb);
	}


	public void deleteInwardSourceById(int inwardSid) {
		inwardsourceRepo.deleteById(inwardSid);

	}

	public InwardSource getByNameInwardSource(String inwardSname) {
		
		return inwardsourceRepo.findByInwardSname(inwardSname) ;
	}

	
}
