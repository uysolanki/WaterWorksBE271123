package com.enumtech.waterworks.entity;

import java.sql.Time;

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
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="attd_seq")
	@SequenceGenerator(name = "attd_seq", sequenceName = "attd_seq", initialValue = 1, allocationSize=1)
	private int attId;
	
	@Column(nullable = true)
	private String dateOfAtt;
	
	@Column(nullable = false,length = 10)
	private long empNo;
	
	@Column(nullable = false,length = 10)
	private Time intime;
	
	@Column(nullable = false,length = 10)
	private Time outtime;
	
	@Column(nullable = false,length = 10)
	private String status;



}
