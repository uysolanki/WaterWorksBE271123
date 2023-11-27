package com.enumtech.waterworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.waterworks.entity.ThirdParty;
import com.enumtech.waterworks.repository.ThirdPartyRepo;

@Service
public class ThirdPartyService {
	@Autowired
	ThirdPartyRepo tprepo;
	
	public ThirdParty addThirdParty(ThirdParty addThirddParty) {
		return tprepo .save(addThirddParty);
		
	}

	public List<ThirdParty> getAllThirdParty() {
		return tprepo.findAll();
	}

	public Optional<ThirdParty> getSingleThirdPartyById(int contactid) {
		return tprepo.findById(contactid);
	}

	public ThirdParty getThirdPartyByName(String name) {
		
		return tprepo.findByName(name);
	}

	public void deleteThirdPartyById(int contactid) {
		
		 tprepo.deleteById(contactid);
	}


	public ThirdParty updateThirdParty(int contactid, ThirdParty tpuser) {
		Optional<ThirdParty> temp= tprepo.findById(contactid);
		ThirdParty thirddb = null;
		if(temp.isPresent())
		{
			thirddb=temp.get();
			thirddb.setName(tpuser.getName());
			thirddb.setMobileno(tpuser.getMobileno());
			thirddb.setProfession(tpuser.getProfession());
		}
		
		return tprepo.save(thirddb);
			
	}

	

	


}
