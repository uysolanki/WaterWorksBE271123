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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ThirdParty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="third_seq")
	@SequenceGenerator(name = "third_seq", sequenceName = "third_seq", initialValue = 1, allocationSize=1)
	private int contactid;
	
	@Column(unique = true)
	private long mobileno;
	
	@Column(nullable = false,length = 10)
	private String name;
	
	@Column(nullable = false)
	private String profession;
	
	

	

}
