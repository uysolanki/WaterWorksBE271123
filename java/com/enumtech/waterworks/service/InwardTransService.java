package com.enumtech.waterworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.waterworks.entity.InwardTrans;
import com.enumtech.waterworks.entity.OutwardTrans;
import com.enumtech.waterworks.entity.SubTrans;
import com.enumtech.waterworks.repository.InwardTransRepo;
import com.enumtech.waterworks.repository.TransRepo;


@Service
public class InwardTransService {
    @Autowired
	InwardTransRepo inwardTransRepo;
    @Autowired
    TransRepo transRepo;
	public InwardTrans addInwardTrans(InwardTrans inwardtrans) {
		
		return inwardTransRepo.save(inwardtrans);
	}
	public List<InwardTrans> getInTransBySourceid(int inwardSid) {
		
		return inwardTransRepo.getInTransBySourceid(inwardSid) ;
	}
	public List<InwardTrans> getAllInwardTrans() {
		
		return inwardTransRepo.findAll();
	}
	public InwardTrans getByRecieptNo(int receiptno) {
		
		return inwardTransRepo.getByRecieptNo(receiptno);
	}
	public List<InwardTrans> getInTransByDate(String tdate) {
		
		return inwardTransRepo.getInTransByDate(tdate);
	}
	public int getSumAmountFromToDate(String fromtdate, String totdate) {
	    
		return inwardTransRepo.getSumAmountFromToDate(fromtdate,totdate);
	}
	public List<InwardTrans> getinwardtransFromToDate(String fromtdate, String totdate) {
		// TODO Auto-generated method stub
		return inwardTransRepo.getinwardtransFromToDate(fromtdate,totdate);
	}
	public int totalrevenue(String fromtdate, String totdate) {
		int a=transRepo.getAllDebitFromtoDate(fromtdate, totdate);
		int b=inwardTransRepo.getSumAmountFromToDate(fromtdate, totdate);
		int c=a+b;
		return c ;
	}
	
	

}
