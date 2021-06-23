package com.cognixia.jumplus.project4.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customeraccount")
public class CustomerAccount {
	
	@Id
	@GeneratedValue
	@Column(name = "customer_account_id")
	private UUID customerAccountId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", columnDefinition = "BINARY(16)")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "account_id", columnDefinition = "BINARY(16)")
	private Account account;
	
	@Column(name = "nickname")
	private String nickname;
	
	@OneToMany(mappedBy="customerAccount")
	private Set<Card> cards;
	
}
