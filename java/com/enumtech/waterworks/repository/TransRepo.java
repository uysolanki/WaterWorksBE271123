package com.enumtech.waterworks.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enumtech.waterworks.entity.SubTrans;

import com.enumtech.waterworks.entity.SubTrans;
@Repository
public interface TransRepo extends  JpaRepository<SubTrans, Integer>{
    
	@Query(value="select * from sub_trans where type=?1",nativeQuery = true)
	List<SubTrans> getByType(String type);
   
	@Query(value="select * from sub_trans where subscriber_no=?1",nativeQuery=true)
	List<SubTrans> getBysubsNo(String subscriberNo);
    
	
	@Query(value="select * from sub_trans where tdate like ?1",nativeQuery=true)
	List<SubTrans> getByDate(String tdate);
    
	@Query(value="select * from sub_trans where tdate like ?1",nativeQuery=true)
	List<SubTrans> getAllCreditTrans();
    
	
	@Query(value="select * from sub_trans where subscriber_no=?1 and tdate between ?2 and ?3",nativeQuery=true)
	List<SubTrans> getFromToDate(int subscriberNo, String fromtdate,String totdate);
    
	
	@Query(value="select sum(debit) from sub_trans inner join subscriber on sub_trans.subscriber_no=subscriber.subscriber_no where current_balance>0 and tdate between ?1 and ?2",nativeQuery=true)
	int getAllDebitFromtoDate(String fromtdate, String totdate);



	
	

}