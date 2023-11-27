package com.enumtech.waterworks.service;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.enumtech.waterworks.entity.SubTrans;
import com.enumtech.waterworks.entity.Subscriber;
import com.enumtech.waterworks.repository.SubsRepo;
import com.enumtech.waterworks.repository.TransRepo;

@Service
public class TransService {
	@Autowired
	TransRepo transRepo;
	@Autowired
	SubsRepo subrepo;

	@Autowired
	SubsService subs;

	@Autowired
	TransService transService;

	public SubTrans addTransaction(SubTrans substrans) {
		int subno = substrans.getSubscriberNo();
		Optional<Subscriber> sub = subrepo.findById(subno);
		int crb = sub.get().getCurrentBalance();
		if (substrans.getAmount() > 0) {
			crb = crb + substrans.getAmount();
			System.out.println(crb);
            
			sub.get().setCurrentBalance(crb);
            substrans.setTotalbalance(crb);
			substrans.setCredit(substrans.getAmount());

		} else {
			System.out.println("amount must be greater than 0");
		}
		return transRepo.save(substrans);
	}

	public List<SubTrans> getAllTrans() {

		return transRepo.findAll();
	}

	public List<SubTrans> getBySubsNo(String subscriberNo) {

		return transRepo.getBysubsNo(subscriberNo);
	}

	public List<SubTrans> getByDate(String tdate) {
		return transRepo.getByDate(tdate);
	}
	
	@Value("${fee}")
	private int fee;
	
	public List<SubTrans> deductTransaction(List<SubTrans> substrans) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
		//int monsub = 200;
     int monh=dateWithoutTime.getMonth();
     
     String month=new DateFormatSymbols().getMonths()[monh];
		System.out.println(fee);


		List<Subscriber> subgetAll = subrepo.findAll();
		int size = subgetAll.size();

		System.out.println(size);
		for (int i = 0; i < size; i++) {

			if (subgetAll.get(i).getConnectionStatus().equals("active")) {

				int crb = subgetAll.get(i).getCurrentBalance();

				crb = crb - fee;
				System.out.println(crb);

				subgetAll.get(i).setCurrentBalance(crb);
				System.out.println(subgetAll);

				int amount;
				int debit;
				int subno;

				amount = fee;
				debit = fee;
				subno = subgetAll.get(i).getSubscriberNo();

				SubTrans substrans1 = new SubTrans();
				substrans1.setAmount(amount);
				substrans1.setDebit(debit);
				substrans1.setSubscriberNo(subno);
				substrans1.setTdate(dateWithoutTime);
				substrans1.setParticular(month+" MonthlyBill");
				substrans1.setTotalbalance(crb);
				substrans.add(substrans1);

			}
		}

		return transRepo.saveAll(substrans);
	}

	public List<SubTrans> getFromToDate(int subscriberNo, String fromtdate, String totdate) {
		
		return transRepo.getFromToDate(subscriberNo,fromtdate,totdate);
	}

	public int getAllDebitFromtoDate(String fromtdate, String totdate) {
		
		return transRepo.getAllDebitFromtoDate(fromtdate,totdate);
	}

	

}
