package com.enumtech.waterworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enumtech.waterworks.entity.InwardTrans;

public interface InwardTransRepo extends JpaRepository<InwardTrans, Integer> {
    
	
	@Query(value="select * from inward_trans where inward_sid=?1",nativeQuery = true)
	List<InwardTrans> getInTransBySourceid(int inwardSid);
    
	@Query(value="select * from inward_trans where receiptno=?1",nativeQuery = true)
	InwardTrans getByRecieptNo(int receiptno);
    
	@Query(value="select * from inward_trans where tdate=?1",nativeQuery = true)
	List<InwardTrans> getInTransByDate(String tdate);
    
	@Query(value="select sum(tamount) from inward_trans where tdate between ?1 and ?2",nativeQuery = true)
	int getSumAmountFromToDate(String fromtdate, String totdate);
	 
    @Query(value="select * from inward_trans where tdate between ?1 and ?2 ",nativeQuery = true)
	List<InwardTrans> getinwardtransFromToDate(String fromtdate, String totdate);

}
