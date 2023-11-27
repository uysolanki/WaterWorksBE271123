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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OutwardTrans {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="outwardTrans_seq")
	@SequenceGenerator(name = "outwardTrans_seq", sequenceName = "outwardTrans_seq", initialValue = 1, allocationSize=1)
	private int outwardTid;
	
	@Column(nullable = false)
	private Date outtdate;
	
	@Column(nullable = false)
	private int outwardSid;
	
	@Column(nullable = false)
	private int outamount;

	@Column(unique = true)
	private int voucherno;
	
	@Column(nullable = false)
	private String paidto;


}
