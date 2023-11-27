package com.enumtech.waterworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.waterworks.entity.Subscriber;
import com.enumtech.waterworks.repository.SubsRepo;

@Service
public class SubsService {
	
	@Autowired
	SubsRepo subsRepo;

	public Subscriber addSubscriber(Subscriber subscriber) {
		
		return subsRepo.save(subscriber);
		
	}

	public Subscriber getSubscriberByNo(int subscriberNo) {
		
		return subsRepo.findById(subscriberNo).get();
	}

	public Subscriber getSubscriberByName(String subscriberFirstName) {
		
		return subsRepo.findByFirstName(subscriberFirstName);
	}

	public List<Subscriber> getSubscriberByZoneno(int zoneno) {
		
		return  subsRepo.findByZoneNo(zoneno);
	}

	public void deleteSubscriber(int subscriberNo) {
		
		
		 subsRepo.deleteById(subscriberNo);
		
	}

	
	public void deleteSubscriberByAdharNo(long subscriberAdharNo) {
		
		
		 subsRepo.deleteByAdharNo(subscriberAdharNo);
		
	}

	public List<Subscriber> getAllSubscriber() {
		
		return subsRepo.findAll();
	}

	public Subscriber updatedRecord(int subscriberNo, Subscriber subscriberUser) {
		
		Optional<Subscriber> temp=subsRepo.findById(subscriberNo);
		Subscriber subsdb = null ;
		 if(temp.isPresent())
		{
		    subsdb=temp.get();
			subsdb.setFirstName(subscriberUser.getFirstName());
			subsdb.setLastName(subscriberUser.getLastName());
			subsdb.setSubscriberMobileNo(subscriberUser.getSubscriberMobileNo());
			subsdb.setSubscriberAdharNo(subscriberUser.getSubscriberAdharNo());
			subsdb.setSubscriberAddress(subscriberUser.getSubscriberAddress());
			subsdb.setSubsciberFinancialStatus(subscriberUser.getSubsciberFinancialStatus());
			subsdb.setConnectionStatus(subscriberUser.getConnectionStatus());
			subsdb.setCurrentBalance(subscriberUser.getCurrentBalance());
		
			
		
		}		
		return  subsRepo.save(subsdb);
	}

	public Subscriber getSubscriberByMobileNo(long subscriberMobileNo) {
		
		return subsRepo.getSubscriberByMobileNo(subscriberMobileNo);
	}

	public Subscriber getSubscriberByAdharNo(long subscriberAdharNo) {
		
		return subsRepo.getSubscriberByAdharNo(subscriberAdharNo);
	}

	public int getCrbBySubno(int subscriberNo) {
		
		return subsRepo.getCrbBySubno(subscriberNo);
	}

	public List<Subscriber> getdefaultersByAmt(int amt) {
		// TODO Auto-generated method stub
		return subsRepo.getdefaultersByAmt(amt);
	}

	public List<Subscriber> getdefaultersBySurname(String lastName) {
		
		return subsRepo.getdefaultersBySurname(lastName);
	}

	public List<Subscriber> getdefaultersByZone(int zoneno) {
		
		return subsRepo.getdefaultersByZone(zoneno);
	}




}
