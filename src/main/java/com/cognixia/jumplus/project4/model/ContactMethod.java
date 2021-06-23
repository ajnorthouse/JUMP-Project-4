package com.cognixia.jumplus.project4.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact_method")
public class ContactMethod {
	
	@Id
	@GeneratedValue
	@Column(name = "contact_method_id", columnDefinition = "BINARY(16)")
	private UUID contactMethodId;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private ContactType type = ContactType.other;
	
	@Column(name = "detail")
	private BigDecimal balance = new BigDecimal("0.00");
	
	@ManyToOne
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customer;

}
