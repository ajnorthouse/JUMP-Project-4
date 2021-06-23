package com.cognixia.jumplus.project4.model;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	Set<CustomerAccount> customers;
	
	@ManyToMany
	@JoinTable(
		name="Account_Log",
		joinColumns = @JoinColumn(name="account_id"),
		inverseJoinColumns = @JoinColumn(name = "log_id", unique = true))
	private Set<Log> accountLogs;
	
}
