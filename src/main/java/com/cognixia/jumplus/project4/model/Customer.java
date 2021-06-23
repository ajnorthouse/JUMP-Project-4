package com.cognixia.jumplus.project4.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private Set<ContactMethod> contactMethods;
	
	@OneToMany(mappedBy="customer")
	Set<CustomerAccount> accounts;
	
	@ManyToMany
	@JoinTable(
		name="Customer_Log",
		joinColumns = @JoinColumn(name="customer_id"),
		inverseJoinColumns = @JoinColumn(name = "log_id", unique = true))
	private Set<Log> customerLogs;

}
