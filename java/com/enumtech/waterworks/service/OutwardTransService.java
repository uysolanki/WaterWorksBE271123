package com.enumtech.waterworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.waterworks.entity.InwardTrans;
import com.enumtech.waterworks.entity.OutwardTrans;
import com.enumtech.waterworks.entity.SubTrans;
import com.enumtech.waterworks.repository.OutwardTransRepo;

@Service
public class OutwardTransService {
    
	@Autowired
	OutwardTransRepo outTransRepo;
	
	public OutwardTrans addOutwardTrans(OutwardTrans outwardtrans) {
		return outTransRepo.save(outwardtrans);
	}

	public List<OutwardTrans> getOutTransBySourceid(int outwardSid) {
		
		return outTransRepo.getOutTransBySourceid(outwardSid);
	}

	public List<OutwardTrans> getAllOutwardTrans() {
		
		return outTransRepo.findAll();
	}

	public OutwardTrans getByVoucherNo(int voucherno) {
		
		return outTransRepo.getByVoucherNo(voucherno);
	}

	public List<OutwardTrans> getOutTransByDate(String tdate) {
		
		return outTransRepo.getOutTransByDate(tdate);
	}

	public List<OutwardTrans> getFromToDateOut(String fromtdate, String totdate) {
		
		return outTransRepo.getFromToDateOut(fromtdate,totdate);
	}

	public int gettotalamtfromTodate(String fromtdate, String totdate) {
		
		return outTransRepo.gettotalamtfromTodate(fromtdate,totdate);
	}

}
