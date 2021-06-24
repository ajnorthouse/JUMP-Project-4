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
	
	
	//constructors
	/** Creates card object.
	 * @param pin
	 * @param customerAccount
	 */
	Card(String pin, CustomerAccount customerAccount) {
		super();
		this.cardId = UUID.randomUUID();
		this.pin = pin;
		this.customerAccount = customerAccount;
	}
	/** Used to create a ContactMethod that was previously deleted.
	 * @param pin
	 * @param customerAccount
	 */
	Card(UUID cardId, String pin, CustomerAccount customerAccount) {
		super();
		this.cardId = cardId;
		this.pin = pin;
		this.customerAccount = customerAccount;
	}


	//pin methods
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
	//customerAccount methods
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}
	
	
	//cardId methods
	public UUID getCardId() {
		return cardId;
	}


	
	
	//toString methods
	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", pin=" + pin + ", customerAccount=" + customerAccount.getCustomerAccountId() + "]";
	}
	
	//toJson methods
	public String toJson() {
		return "{\"cardId\" : " + cardId + "\""
				+ ", \"pin\" : \"" + pin + "\""
				+ ", \"customerAccount\" : \"" + customerAccount.getCustomerAccountId() + "\"" +
		"}";
	}
	
}
