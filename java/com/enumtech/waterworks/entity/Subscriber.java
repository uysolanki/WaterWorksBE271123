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
public class Subscriber {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="subs_seq")
	@SequenceGenerator(name = "subs_seq", sequenceName = "subs_seq", initialValue = 1, allocationSize=1)	
	private int subscriberNo;
	
	@Column(nullable=false)
	private String firstName;
	
	@Column(nullable=false)
	private String lastName;
	
	@Column(nullable=false,unique = true)
	private long subscriberMobileNo;
	
	@Column(unique=true)
	private long subscriberAdharNo;
	
	@Column(nullable=false  )
	private String subscriberAddress;
	
	@Column(nullable=false)
	private int zoneno;
	
	@Column(nullable=false  )
	private String subsciberFinancialStatus;
	
	@Column(nullable=false)
	private String connectionStatus;
	
	@Column(nullable=false  )
	private  int currentBalance;


	@JoinColumn(name = "subscriberNo", referencedColumnName = "subscriberNo") ///// name=primary key//then refernce to foreingn key
	@OneToMany(cascade = CascadeType.ALL)
	List<SubTrans> substrans_list;
}
