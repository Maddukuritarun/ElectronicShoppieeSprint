package com.cg.es.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="electronic_product_orders")
public class ElectronicProductOrderEntity {

	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@Column(name="product_qty")
	private Integer productQty;
	
	@Column(name= "order_date", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate orderDate;
	
	@Column(name="amount")	
	private double amount;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private CustomerEntity customer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="basket_id")
	private BasketEntity basket;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="manager_id")
//	private Manager manager;
	

	public ElectronicProductOrderEntity() {
		super();
	}


	public ElectronicProductOrderEntity(Long orderId, Integer productQty, LocalDate orderDate, double amount,
			CustomerEntity customer) {
		super();
		this.orderId = orderId;
		this.productQty = productQty;
		this.orderDate = orderDate;
		this.amount = amount;
		this.customer = customer;
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Integer getProductQty() {
		return productQty;
	}


	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public CustomerEntity getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}



	

	
	

}