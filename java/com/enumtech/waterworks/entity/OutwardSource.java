package com.enumtech.waterworks.entity;

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
public class OutwardSource {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="outwardSource_seq")
	@SequenceGenerator(name = "outwardSource_seq", sequenceName = "outwardSource_seq", initialValue = 1, allocationSize=1)	private int outwardSid;
	@Column(nullable = false )
	private String outwardSname;
}