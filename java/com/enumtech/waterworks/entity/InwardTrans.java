package com.enumtech.waterworks.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InwardTrans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="inwardTrans_seq")
	@SequenceGenerator(name = "inwardTrans_seq", sequenceName = "inwardTrans_seq", initialValue = 1, allocationSize=1)
	private int inwardTid;
	
	@Column(nullable = false)
	private Date tdate;
	
	@Column(nullable = false)
	private int tamount;
	
//	@Column(unique=true)
//	private int receiptno;
	
	@Column(nullable = false)
	private int inwardSid;

	
}