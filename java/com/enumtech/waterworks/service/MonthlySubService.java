package com.enumtech.waterworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.waterworks.entity.MonthlySubscription;
import com.enumtech.waterworks.repository.MonthlySubRepo;

@Service
public class MonthlySubService {
	@Autowired
	MonthlySubRepo msrepo;

	public MonthlySubscription addMonthlySubscription(MonthlySubscription ms) {
		
		return msrepo.save(ms);
	}

	public MonthlySubscription updateMonthlySubscription(int subscriptionid, MonthlySubscription msuser) {
		Optional<MonthlySubscription> temp= msrepo.findById(subscriptionid);
		MonthlySubscription monthdb = null;
		if(temp.isPresent())
		{
		monthdb=temp.get();
		monthdb.setMonthlyfee(msuser.getMonthlyfee());
		}
		
		return msrepo.save(monthdb);
		
	}

	public List<MonthlySubscription> getAllMonthlySubscription() {
		return msrepo.findAll();
	}
	

}
