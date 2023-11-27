package com.enumtech.waterworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enumtech.waterworks.entity.Subscriber;
@Repository 
public interface SubsRepo extends JpaRepository<Subscriber, Integer> {
	Subscriber findByFirstName(String subscriberFirstName);

	
	@Query(value="select * from subscriber where zoneno=?1",nativeQuery = true)
	List<Subscriber> findByZoneNo(int zoneno);
	
	@Query(value="delete from subscriber where subscriber_adhar_no=?1",nativeQuery=true)
	void deleteByAdharNo(long subscriberAdharNo);

     @Query(value="select * from subscriber where subscriber_mobile_no=?1",nativeQuery=true)
	Subscriber getSubscriberByMobileNo(long subscriberMobileNo);

    @Query(value="select * from subscriber where subscriber_adhar_no=?1",nativeQuery = true)
	Subscriber getSubscriberByAdharNo(long subscriberAdharNo);

    @Query(value="select current_balance from subscriber where subscriber_no=?1",nativeQuery = true)
	int getCrbBySubno(int subscriberNo);

    @Query(value="select * from subscriber where current_balance<=0 and current_balance>=-?1",nativeQuery = true)
	List<Subscriber> getdefaultersByAmt(int amt);

    @Query(value="select * from subscriber where last_name=?1 and current_balance<=0",nativeQuery = true)
    List<Subscriber> getdefaultersBySurname(String lastName);

    @Query(value="select * from subscriber where zoneno=?1 and current_balance<=0",nativeQuery = true)
	List<Subscriber> getdefaultersByZone(int zoneno);

    



}
