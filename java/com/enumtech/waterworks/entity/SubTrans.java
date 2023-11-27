package com.enumtech.waterworks.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SubTrans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="subtrans_seq")
	@SequenceGenerator(name = "subtrans_seq", sequenceName = "subtrans_seq", initialValue = 1, allocationSize=1)
	private int  tid;

	private Date tdate;
	
	private String particular;
	
	private int subscriberNo;
	
	private int amount;
	
    private int credit;
	
	private int debit;
	
	private int totalbalance;
	
	
}