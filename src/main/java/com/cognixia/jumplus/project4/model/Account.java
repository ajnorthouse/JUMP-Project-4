package com.cognixia.jumplus.project4.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue
	@Column(name = "account_id", columnDefinition = "BINARY(16)")
	private UUID accountId;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private AccountType type;
	
	@Column(name = "balance")
	private BigDecimal balance = new BigDecimal("0.00");
	
	@OneToMany(mappedBy="account")
	private List<CustomerAccount> customers;
	
	@OneToMany(mappedBy="account")
	private List<AccountLog> accountLogs;
	
	
	//constructors
	/** Creates an account object.
	 * @param type of type AccountType
	 * @param balance of type BigDecimal
	 */
	public Account(AccountType type, BigDecimal balance, List<CustomerAccount> customers, List<AccountLog> accountLogs) {
		super();
		this.accountId = UUID.randomUUID();
		this.type = type;
		this.balance = balance;
		this.accountLogs = accountLogs;
		this.customers = customers;
	}
	/** Used to recreate an account that was previously deleted.
	 * @param accountId of type UUID
	 * @param customers of type List(CustomerAccount)
	 * @param accountLogs of type List(Log)
	 */
	public Account(UUID accountId, AccountType type, BigDecimal balance, List<CustomerAccount> customers, List<AccountLog> accountLogs) {
		super();
		this.accountId = accountId;
		this.type = type;
		this.balance = balance;
		this.customers = customers;
		this.accountLogs = accountLogs;
	}
	
	
	//type methods
	public AccountType getType() {
		return type;
	}
	
	
	//balance methods
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
	//customers methods
	public List<CustomerAccount> getCustomers() {
		return customers;
	}
	public void setCustomers(List<CustomerAccount> customers) {
		this.customers = customers;
	}
	
	
	//accountLogs methods
	public List<AccountLog> getAccountLogs() {
		return accountLogs;
	}
	public void setAccountLogs(List<AccountLog> accountLogs) {
		this.accountLogs = accountLogs;
	}
	
	
	//accountId methods
	public UUID getAccountId() {
		return accountId;
	}
	
	
	
	//toString methods
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", type=" + type + ", balance=" + balance.toString() + ", customers=" + customersToString() + "]";
	}
	/** Returns a String list of the customers' id's. */
	public String customersToString() {
		//StringBuilder for resource easement.
		StringBuilder customerString = new StringBuilder('[');
		
		//if statement to prevent null-pointer error:
		if (customers.size() != 0) {
			
			//for loop to generate string using Customer's .toJson()
			for (int iter = 0; iter < customers.size(); iter++) {
				customerString.append(customers.get(iter).getCustomer().getCustomerId());
				
				//if-statement to prevent extra "," being to the end
				if (iter != customers.size() - 1) {
					customerString.append(",");
				}
			}
		}
		
		//appends closing bracket
		customerString.append("]");
		
		//returns the customerString
		return customerString.toString();
	}
	
	//toJson methods
	public String toJson() {
		return "{\"accountId\" : " + accountId + "\""
				+ ", \"type\" : \"" + type + "\""
				+ ", \"balance\" : \"" + balance + "\""
				+ ", \"customers\" : \"" + customersToJson() + "\"" +
		"}";
	}
	/** Returns a JSON list of the customers' id's. */
	public String customersToJson() {
		//StringBuilder for resource easement.
		StringBuilder customerString = new StringBuilder('{');
		
		//if statement to prevent null-pointer error:
		if (customers.size() != 0) {
			
			//for loop to generate string using Customer's .toJson()
			for (int iter = 0; iter < customers.size(); iter++) {
				customerString.append(customers.get(iter).getCustomer().getCustomerId());
				
				//if-statement to prevent extra "," being to the end
				if (iter != customers.size() - 1) {
					customerString.append(",");
				}
			}
		}
		
		//appends closing bracket
		customerString.append("}");
		
		//returns the customerString
		return customerString.toString();
	}	

}
