package com.cognixia.jumplus.project4.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
	
	@Id
	@GeneratedValue
	@Column(name = "card_id", columnDefinition = "BINARY(16)")
	private UUID cardId;
	
	@Column(name = "pin")
	private String pin;
	
	@ManyToOne
	@JoinColumn(name="customer_account_id", nullable=false)
	private CustomerAccount customerAccount;

}
