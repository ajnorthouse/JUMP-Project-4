package com.cognixia.jumplus.project4.model;

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
	private ContactType type;
	
	@Column(name = "detail")
	private String detail;
	
	@ManyToOne
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customer;
	
	
	//constructors
	/** Creates a ContactMethod object.
	 * @param type
	 * @param detail
	 * @param customer
	 */
	ContactMethod(ContactType type, String detail, Customer customer) {
		super();
		this.contactMethodId = UUID.randomUUID();
		this.type = type;
		this.detail = detail;
		this.customer = customer;
	}
	/** Used to create a ContactMethod that was previously deleted.
	 * @param contactMethodId
	 * @param type
	 * @param detail
	 * @param customer
	 */
	ContactMethod(UUID contactMethodId, ContactType type, String detail, Customer customer) {
		super();
		this.contactMethodId = contactMethodId;
		this.type = type;
		this.detail = detail;
		this.customer = customer;
	}


	//type methods
	public ContactType getType() {
		return type;
	}
	public void setType(ContactType type) {
		this.type = type;
	}


	//detail methods
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}


	//contactMethodId methods
	public UUID getContactMethodId() {
		return contactMethodId;
	}


	//customer  methods
	public Customer getCustomer() {
		return customer;
	}


	
	
	//toString methods
	@Override
	public String toString() {
		return "ContactMethod [contactMethodId=" + contactMethodId + ", type=" + type + ", detail=" + detail
				+ ", customer=" + customer.getCustomerId() + "]";
	}
	
	//toJson Methods
	public String toJson() {
		return "{\"contactMethodId\" : " + contactMethodId + "\""
				+ ", \"type\" : \"" + type + "\""
				+ ", \"detail\" : \"" + detail + "\""
				+ ", \"customer\" : \"" + customer.getCustomerId() + "\"" +
		"}";
	}
	
}
