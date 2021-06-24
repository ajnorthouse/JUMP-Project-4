package com.cognixia.jumplus.project4.model;

import java.util.List;
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
	private List<Card> cards;
	
	
	//constructors
	/** Creates a CustomerAccount object. A card can be created afterwards.
	 * @param customer of type Customer
	 * @param account of type Account
	 * @param nickname of type String
	 */
	CustomerAccount(Customer customer, Account account, String nickname, List<Card> cards) {
		super();
		this.customerAccountId = UUID.randomUUID();
		this.customer = customer;
		this.account = account;
		this.nickname = nickname;
		this.cards = cards;
	}
	/** This constructor would be used to recreate a CustomerAccount that was previously deleted.
	 * @param customerAccountId of type UUID
	 * @param customer of type Customer
	 * @param account of type Account
	 * @param nickname of type String
	 * @param cards of type List(Card)
	 */
	CustomerAccount(UUID customerAccountId, Customer customer, Account account, String nickname, List<Card> cards) {
		super();
		this.customerAccountId = customerAccountId;
		this.customer = customer;
		this.account = account;
		this.nickname = nickname;
		this.cards = cards;
	}
	
	
	//customer methods
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	//account methods
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	//cards methods
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
	//customerAccountId methods
	public UUID getCustomerAccountId() {
		return customerAccountId;
	}
	
	
	//nickname methods
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	//toString methods
	@Override
	public String toString() {
		return "Account [customerAccountId=" + customerAccountId + ", customer=" + customer.getCustomerId() + ", account=" + account.getAccountId() + ", nickname=" + nickname + ", cards=" + cardsToString() + "]";
	}
	/** Returns a JSON list of the cards' id's. */
	public String cardsToString() {
		//StringBuilder for resource easement.
		StringBuilder cardsString = new StringBuilder('[');
		
		//if statement to prevent null-pointer error:
		if (cards.size() != 0) {
			
			//for loop to generate string using Customer's .toJson()
			for (int iter = 0; iter < cards.size(); iter++) {
				cardsString.append(cards.get(iter).getCardId());
				
				//if-statement to prevent extra "," being to the end
				if (iter != cards.size() - 1) {
					cardsString.append(",");
				}
			}
		}
		
		//appends closing bracket
		cardsString.append("]");
		
		//returns the customerString
		return cardsString.toString();
	}
	
	//toJson methods
	public String toJson() {
		return "{\"customerAccountId\" : " + customerAccountId + "\""
				+ ", \"customer\" : \"" + customer.getCustomerId() + "\""
				+ ", \"account\" : \"" + account.getAccountId() + "\""
				+ ", \"nickname\" : \"" + nickname + "\"" 
				+ ", \"cards\" : \"" + cardsToJson() + "\""  +
		"}";
	}
	/** Returns a JSON list of the cards' id's. */
	public String cardsToJson() {
		//StringBuilder for resource easement.
		StringBuilder cardsString = new StringBuilder('{');
		
		//if statement to prevent null-pointer error:
		if (cards.size() != 0) {
			
			//for loop to generate string using Customer's .toJson()
			for (int iter = 0; iter < cards.size(); iter++) {
				cardsString.append(cards.get(iter).getCardId());
				
				//if-statement to prevent extra "," being to the end
				if (iter != cards.size() - 1) {
					cardsString.append(",");
				}
			}
		}
		
		//appends closing bracket
		cardsString.append("}");
		
		//returns the customerString
		return cardsString.toString();
	}
	
}
