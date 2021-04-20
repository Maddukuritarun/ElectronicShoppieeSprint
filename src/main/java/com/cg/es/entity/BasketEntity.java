package com.cg.es.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="basket")
public class BasketEntity {

	@Id
	@Column(name="basket_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long basketId;
	
	@Column(name="total_products")
	private Integer quantityOfProduct;
	
	@Column(name="total_amount")
	private Double grandTotal;

	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Basket_Product", 
        joinColumns = { @JoinColumn(name = "basket_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
	private List<ElectronicProductEntity> electronicProduct = new ArrayList<ElectronicProductEntity>();
	
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private CustomerEntity customer;
	
	@OneToMany(mappedBy = "basket")
	private List<ElectronicProductOrderEntity> productOrders;
	

	public BasketEntity() {
		super();
	}

	public BasketEntity(Long basketId, Integer quantityOfProduct, Double grandTotal, CustomerEntity customer) {
		super();
		this.basketId = basketId;
		this.quantityOfProduct = quantityOfProduct;
		this.grandTotal = grandTotal;
//		this.electronicProduct = electronicProduct;
		this.customer = customer;
	}
	
	public Long getBasketId() {
		return basketId;
	}
	
	public void setBasketId(Long basketId) {
		this.basketId = basketId;
	}
	
	public Integer getQuantityOfProduct() {
		return quantityOfProduct;
	}
	
	public void setQuantityOfProduct(Integer quantityOfProduct) {
		this.quantityOfProduct = quantityOfProduct;
	}
	
	public Double getGrandTotal() {
		return grandTotal;
	}
	
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public List<ElectronicProductEntity> getElectronicProduct() {
		return electronicProduct;
	}
	
	public void setElectronicProduct(List<ElectronicProductEntity> electronicProduct) {
		this.electronicProduct = electronicProduct;
	}
	
	public CustomerEntity getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
		
	

	

}