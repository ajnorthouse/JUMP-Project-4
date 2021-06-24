package com.cognixia.jumplus.project4.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name = "customer_id", columnDefinition = "BINARY(16)")
	private UUID customerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy="customer")
	private List<ContactMethod> contactMethods;
	
	@OneToMany(mappedBy="customer")
	private List<CustomerAccount> accounts;
	
	@OneToMany(mappedBy="customer")
	private List<CustomerLog> customerLogs;
	
	
	//constructors
	/** Creates a Customer.
	 * @param name
	 * @param username
	 * @param password
	 * @param contactMethods
	 */
	Customer(String name, String username, String password, List<ContactMethod> contactMethods,
			List<CustomerAccount> accounts, List<CustomerLog> customerLogs) {
		super();
		this.customerId = UUID.randomUUID();
		this.name = name;
		this.username = username;
		this.password = password;
		this.contactMethods = contactMethods;
		this.accounts = accounts;
		this.customerLogs = customerLogs;
	}
	/** Used to recreate a Customer that was previously deleted.
	 * @param customerId
	 * @param name
	 * @param username
	 * @param password
	 * @param contactMethods
	 * @param accounts
	 * @param customerLogs
	 */
	Customer(UUID customerId, String name, String username, String password, 
			List<ContactMethod> contactMethods, List<CustomerAccount> accounts, List<CustomerLog> customerLogs) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.contactMethods = contactMethods;
		this.accounts = accounts;
		this.customerLogs = customerLogs;
	}
	
	
	//name methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	//username methods
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	//password methods
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//contactMethods methods
	public List<ContactMethod> getContactMethods() {
		return contactMethods;
	}
	public void setContactMethods(List<ContactMethod> contactMethods) {
		this.contactMethods = contactMethods;
	}
	
	
	//accounts methods
	public List<CustomerAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<CustomerAccount> accounts) {
		this.accounts = accounts;
	}
	
	
	//customerLogs methods
	public List<CustomerLog> getCustomerLogs() {
		return customerLogs;
	}
	public void setCustomerLogs(List<CustomerLog> customerLogs) {
		this.customerLogs = customerLogs;
	}
	
	
	//customerId methods
	public UUID getCustomerId() {
		return customerId;
	}
	
	
	//toString methods
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", username=" + username + ", password="
				+ password + ", contactMethods=" + contactMethods + ", accounts=" + accountsToString() + ", customerLogs="
				+ customerLogs + "]";
	}
	/** Returns a String list of the accounts' id's. */
	public String accountsToString() {
		//StringBuilder for resource easement.
		StringBuilder accountString = new StringBuilder('[');
		
		//if statement to prevent null-pointer error:
		if (accounts.size() != 0) {
			
			//for loop to generate string using Customer's .toJson()
			for (int iter = 0; iter < accounts.size(); iter++) {
				accountString.append(accounts.get(iter).getAccount().getAccountId());
				
				//if-statement to prevent extra "," being to the end
				if (iter != accounts.size() - 1) {
					accountString.append(",");
				}
			}
		}
		
		//appends closing bracket
		accountString.append("]");
		
		//returns the customerString
		return accountString.toString();
	}
	
	//toJson methods
	public String toJson() {
		return "{\"customerId\" : " + customerId + "\""
				+ ", \"name\" : \"" + name + "\""
				+ ", \"username\" : \"" + username + "\""
				+ ", \"password\" : \"" + password + "\""
				+ ", \"contactMethods\" : \"" + contactMethods + "\""
				+ ", \"accounts\" : \"" + accountsToJson() + "\""
				+ ", \"customerLogs\" : \"" + customerLogs + "\"" +
		"}";
	}
	/** Returns a JSON list of the accounts' id's. */
	public String accountsToJson() {
		//StringBuilder for resource easement.
		StringBuilder accountString = new StringBuilder('{');
		
		//if statement to prevent null-pointer error:
		if (accounts.size() != 0) {
			
			//for loop to generate string using Customer's .toJson()
			for (int iter = 0; iter < accounts.size(); iter++) {
				accountString.append(accounts.get(iter).getAccount().getAccountId());
				
				//if-statement to prevent extra "," being to the end
				if (iter != accounts.size() - 1) {
					accountString.append(",");
				}
			}
		}
		
		//appends closing bracket
		accountString.append("}");
		
		//returns the customerString
		return accountString.toString();
	}	
	
}
