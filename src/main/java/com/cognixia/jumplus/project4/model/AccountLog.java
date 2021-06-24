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
@Table(name = "account_log")
public class AccountLog {
	
	@Id
	@GeneratedValue
	@Column(name = "account_log_id", columnDefinition = "BINARY(16)")
	private UUID accountLogId;
	
	@Column(name = "timestamp")
	private Timestamp timestamp;
	
	@Column(name = "statement")
	private String statement;
	
	@ManyToOne
	@JoinColumn(name="account_id", nullable=false)
	private Account account;
	
	
	//constructors
	/** Create a new AccountLog.
	 * @param statement
	 * @param account
	 */
	AccountLog(String statement, Account account) {
		super();
		this.accountLogId = UUID.randomUUID();
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.statement = statement;
		this.account = account;
	}
	/** Used to create a previously deleted AccountLog.
	 * @param accountLogId
	 * @param timestamp
	 * @param statement
	 * @param account
	 */
	AccountLog(UUID accountLogId, Timestamp timestamp, String statement, Account account) {
		super();
		this.accountLogId = accountLogId;
		this.timestamp = timestamp;
		this.statement = statement;
		this.account = account;
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
	public UUID getAccountLogId() {
		return accountLogId;
	}


	//account methods
	public Account getAccount() {
		return account;
	}


	//toString methods
	@Override
	public String toString() {
		return "AccountLog [accountLogId=" + accountLogId + ", timestamp=" + timestamp + ", statement=" + statement + ", account="
				+ account.getAccountId() + "]";
	}
	
	//toJson methods
	public String toJson() {
		return "{\"accountLogId\" : " + accountLogId + "\""
				+ ", \"timestamp\" : \"" + timestamp + "\""
				+ ", \"statement\" : \"" + statement + "\""
				+ ", \"account\" : \"" + account.getAccountId() + "\"" +
		"}";
	}
	
}
