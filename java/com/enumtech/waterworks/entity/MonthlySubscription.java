package com.enumtech.waterworks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonthlySubscription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int monthlysubid;
	
	private int monthlyfee;

	

}
