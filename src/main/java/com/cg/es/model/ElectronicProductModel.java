package com.cg.es.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ElectronicProductModel {

	@NotEmpty(message="productId  cannot be empty")
	@NotNull(message = "productId cannot be omitted")
	private Long productId;

	@NotEmpty(message="productName  cannot be empty")
	@NotNull(message = "productName cannot be omitted")
	private String productName;

	private double productPrice;

	private LocalDate createdDate;
	
	private String productType;
	
	public ElectronicProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ElectronicProductModel(
			@NotEmpty(message = "productId  cannot be empty") @NotNull(message = "productId cannot be omitted") Long productId,
			@NotEmpty(message = "productName  cannot be empty") @NotNull(message = "productName cannot be omitted") String productName,
			double productPrice, LocalDate createdDate, String productType) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.createdDate = createdDate;
		this.productType = productType;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
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
		ElectronicProductModel other = (ElectronicProductModel) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ElectronicProductModel [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", createdDate=" + createdDate + ", productType=" + productType + "]";
	}
	
	

}
