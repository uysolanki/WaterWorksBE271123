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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Zone {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="zone_seq")
	@SequenceGenerator(name = "zone_seq", sequenceName = "zone_seq", initialValue = 1, allocationSize=1)
	private int zoneno;
	
	@Column(nullable=false)
	private String zonename;
	
	@JoinColumn(name = "zoneno", referencedColumnName = "zoneno") ///// name=primary key//then refernce to foreingn key
	@OneToMany(cascade = CascadeType.ALL)
	List<Subscriber> subscriber_list;

	

}
