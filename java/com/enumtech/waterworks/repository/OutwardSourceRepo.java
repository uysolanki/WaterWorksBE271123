package com.enumtech.waterworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enumtech.waterworks.entity.OutwardSource;
@Repository
public interface OutwardSourceRepo extends JpaRepository<OutwardSource, Integer> {


}
