package com.cognixia.jumplus.project4.model;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class Log {
	
	@Id
	@GeneratedValue
	@Column(name = "log_id", columnDefinition = "BINARY(16)")
	private UUID logId;
	
	@Column(name = "timestamp")
	private Timestamp timestamp;
	
	@Column(name = "statement")
	private String statement;
	
	@ManyToMany(mappedBy = "customerLogs")
	Set<Customer> customer;
	
	@ManyToMany(mappedBy = "accountLogs")
	Set<Account> account;

}
