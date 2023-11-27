package com.enumtech.waterworks.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InwardSource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="inwardSource_seq")
	@SequenceGenerator(name = "inwardSource_seq", sequenceName = "inwardSource_seq", initialValue = 1, allocationSize=1)
	private int inwardSid;
	
	@Column(nullable = false)
	private String inwardSname;

	@JoinColumn(name = "inwardSid", referencedColumnName = "inwardSid") ///// name=primary key//then refernce to foreingn key
	@OneToMany(cascade = CascadeType.ALL)
	List<InwardTrans> inwardtrans_list;

}