package com.cg.es.model;

import java.util.List;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cg.es.entity.ElectronicProductEntity;

public class BasketModel {

//	@NotNull(message = "basketId cannot be null")
//	@NotEmpty(message = "basketId cannot be omitted")
	private Long basketId;

//	@NotEmpty(message = "total  cannot be empty")
//	@NotNull(message = "total cannot be omitted")
	private Double grandTotal;

//	@NotEmpty(message = "cannot be empty")
//	@NotNull(message = "cannot be omitted")
	private Integer quantityOfProduct;

	private List<Long> electronicProduct;

	private Long customerId;

	public BasketModel() {

	}

	public BasketModel(Long basketId, Double grandTotal, Integer quantityOfProduct, Long customerId) {
		super();
		this.basketId = basketId;
		this.grandTotal = grandTotal;
		this.quantityOfProduct = quantityOfProduct;
//		this.electronicProduct = electronicProduct;
		this.customerId = customerId;
	}

	public Long getBasketId() {
		return basketId;
	}

	public void setBasketId(Long basketId) {
		this.basketId = basketId;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Integer getQuantityOfProduct() {
		return quantityOfProduct;
	}

	public void setQuantityOfProduct(Integer quantityOfProduct) {
		this.quantityOfProduct = quantityOfProduct;
	}



	public List<Long> getElectronicProduct() {
		return electronicProduct;
	}

	public void setElectronicProduct(List<Long> electronicProduct) {
		this.electronicProduct = electronicProduct;
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
		result = prime * result + ((basketId == null) ? 0 : basketId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((electronicProduct == null) ? 0 : electronicProduct.hashCode());
		result = prime * result + ((grandTotal == null) ? 0 : grandTotal.hashCode());
		result = prime * result + ((quantityOfProduct == null) ? 0 : quantityOfProduct.hashCode());
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
		BasketModel other = (BasketModel) obj;
		if (basketId == null) {
			if (other.basketId != null)
				return false;
		} else if (!basketId.equals(other.basketId))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (electronicProduct == null) {
			if (other.electronicProduct != null)
				return false;
		} else if (!electronicProduct.equals(other.electronicProduct))
			return false;
		if (grandTotal == null) {
			if (other.grandTotal != null)
				return false;
		} else if (!grandTotal.equals(other.grandTotal))
			return false;
		if (quantityOfProduct == null) {
			if (other.quantityOfProduct != null)
				return false;
		} else if (!quantityOfProduct.equals(other.quantityOfProduct))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BasketModel [basketId=" + basketId + ", grandTotal=" + grandTotal + ", quantityOfProduct="
				+ quantityOfProduct + ", electronicProduct=" + electronicProduct + ", customerId=" + customerId + "]";
	}

	
}