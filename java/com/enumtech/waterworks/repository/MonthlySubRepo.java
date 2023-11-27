package com.enumtech.waterworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enumtech.waterworks.entity.MonthlySubscription;

@Repository
public interface MonthlySubRepo extends JpaRepository<MonthlySubscription, Integer> {

}
