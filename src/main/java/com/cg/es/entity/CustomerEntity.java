package com.cg.es.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.es.model.AddressModel;



@Entity
@Table(name="customers")
public class CustomerEntity {

	@Id
	@Column(name="customer_id")
	private Long customerId;

	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_password")
	private String customerPassword;

	@Column(name="customer_email")
	private String customerEmail;

	@Column(name="customer_phone")
	private String customerPhone;

	@Column(name="adress")
	@Embedded
	private AddressModel address;
     
//	@OneToMany(mappedBy = "customer")
//	private List<ElectronicProductOrderEntity> productOrders;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="manager_id")
//	private Manager manager;


	public CustomerEntity() {
		super();
	}


	public CustomerEntity(Long customerId, String customerName, String customerPassword, String customerEmail,
			String customerPhone, AddressModel address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.address = address;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerPassword() {
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public AddressModel getAddress() {
		return address;
	}


	public void setAddress(AddressModel address) {
		this.address = address;
	}





	
	
	
}
