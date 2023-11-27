package com.enumtech.waterworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.waterworks.entity.OutwardSource;
import com.enumtech.waterworks.repository.OutwardSourceRepo;

@Service
public class OutwardSourceService {

	@Autowired
	OutwardSourceRepo outSourceRepo;
	public OutwardSource addOutwardSource(OutwardSource outwardsource) {
		
		return outSourceRepo.save(outwardsource);
	}
	public List<OutwardSource> getAllOutwardSource() {
		return outSourceRepo.findAll();
	}
	public Optional<OutwardSource> getByIdOutwardSource(int outwardSid) {
		return outSourceRepo.findById(outwardSid);
	}
	public void deleteOutwardSourceById(int outwardSid) {
		
		outSourceRepo.deleteById(outwardSid);
	}
	
	public OutwardSource updateOutwardSourceById(int outwardSid,OutwardSource outSource) {
		Optional<OutwardSource> temp = outSourceRepo.findById(outwardSid);
		OutwardSource outwardsodb = null;
		if (temp.isPresent()) {
			outwardsodb = temp.get();
			outwardsodb.setOutwardSname(outSource.getOutwardSname());

		}

		return  outSourceRepo.save(outwardsodb);
	}

}
