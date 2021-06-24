package com.cognixia.jumplus.project4.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_log")
public class CustomerLog {
	
	@Id
	@GeneratedValue
	@Column(name = "customer_log_id", columnDefinition = "BINARY(16)")
	private UUID customerLogId;
	
	@Column(name = "timestamp")
	private Timestamp timestamp;
	
	@Column(name = "statement")
	private String statement;
	
	@ManyToOne
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customer;
	
	
	//constructors
	/** Create a new CustomerLog.
	 * @param statement
	 * @param customer
	 */
	CustomerLog(String statement, Customer customer) {
		super();
		this.customerLogId = UUID.randomUUID();
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.statement = statement;
		this.customer = customer;
	}
	/** Used to create a previously deleted CustomerLog.
	 * @param customerLogId
	 * @param timestamp
	 * @param statement
	 * @param customer
	 */
	CustomerLog(UUID customerLogId, Timestamp timestamp, String statement, Customer customer) {
		super();
		this.customerLogId = customerLogId;
		this.timestamp = timestamp;
		this.statement = statement;
		this.customer = customer;
	}


	//timestamp methods
	public Timestamp getTimestamp() {
		return timestamp;
	}


	//statement methods
	public String getStatement() {
		return statement;
	}


	//logId methods
	public UUID getCustomerLogId() {
		return customerLogId;
	}


	//customer methods
	public Customer getCustomer() {
		return customer;
	}


	//toString methods
	@Override
	public String toString() {
		return "CustomerLog [customerLogId=" + customerLogId + ", timestamp=" + timestamp + ", statement=" + statement + ", customer="
				+ customer.getCustomerId() + "]";
	}
	
	//toJson methods
	public String toJson() {
		return "{\"customerLogId\" : " + customerLogId + "\""
				+ ", \"timestamp\" : \"" + timestamp + "\""
				+ ", \"statement\" : \"" + statement + "\""
				+ ", \"customer\" : \"" + customer.getCustomerId() + "\"" +
		"}";
	}
	
}
