package com.cg.es.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ElectronicProductOrderModel {
	
	@NotEmpty(message="orderId  cannot be empty")
	@NotNull(message = "orderId cannot be omitted")
	private Long orderId;
	
	private Integer productQty;
	
	private LocalDate orderDate;

	private double amount;

	@NotEmpty(message="customerId  cannot be empty")
	@NotNull(message = "customerId cannot be omitted")
	private Long customerId;

	public ElectronicProductOrderModel(
			@NotEmpty(message = "orderId  cannot be empty") @NotNull(message = "orderId cannot be omitted") Long orderId,
			Integer productQty, LocalDate orderDate, double amount,
			@NotEmpty(message = "customerId  cannot be empty") @NotNull(message = "customerId cannot be omitted") Long customerId) {
		super();
		this.orderId = orderId;
		this.productQty = productQty;
		this.orderDate = orderDate;
		this.amount = amount;
		this.customerId = customerId;
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((productQty == null) ? 0 : productQty.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElectronicProductOrderModel other = (ElectronicProductOrderModel) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (productQty == null) {
			if (other.productQty != null)
				return false;
		} else if (!productQty.equals(other.productQty))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ElectronicProductOrderModel [orderId=" + orderId + ", productQty=" + productQty + ", orderDate="
				+ orderDate + ", amount=" + amount + ", customerId=" + customerId + "]";
	}
	
	
}
