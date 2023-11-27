package com.enumtech.waterworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enumtech.waterworks.entity.OutwardTrans;
import com.enumtech.waterworks.entity.SubTrans;
@Repository
public interface OutwardTransRepo extends JpaRepository<OutwardTrans, Integer> {
	@Query(value="select * from outward_trans where outward_sid=?1",nativeQuery = true)
	List<OutwardTrans> getOutTransBySourceid(int outwardSid);
    
	@Query(value="select * from outward_trans where voucherno=?1",nativeQuery = true)
	OutwardTrans getByVoucherNo(int voucherno);
    
	@Query(value="select * from outward_trans where outtdate=?1",nativeQuery = true)
	List<OutwardTrans> getOutTransByDate(String tdate);
    
	@Query(value="select * from outward_trans where outtdate between ?1 and ?2",nativeQuery=true)
	List<OutwardTrans> getFromToDateOut(String fromtdate, String totdate);
    
	
	@Query(value="select sum(outamount) from outward_trans where outtdate between ?1 and ?2",nativeQuery=true)
	int gettotalamtfromTodate(String fromtdate, String totdate);

}
