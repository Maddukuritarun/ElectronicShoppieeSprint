package com.cg.es.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="managers")
public class Manager {

	@Id
	@Column(name="manager_id")
	private Long managerId;

	@Column(name="password")
	private String password;
	
	@OneToMany
	private List<ElectronicProductEntity> electronicProducts;
	
//	@OneToMany
//	private List<CustomerEntity> customers;
	
//	@OneToMany
//	private List<ElectronicProductOrderEntity> productOrders;
	

	public Manager() {
		super();
	}


	public Manager(Long managerId, String password) {
		super();
		this.managerId = managerId;
		this.password = password;
		
	}


	public Long getManagerId() {
		return managerId;
	}


	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<ElectronicProductEntity> getElectronicProducts() {
		return electronicProducts;
	}


	public void setElectronicProducts(List<ElectronicProductEntity> electronicProducts) {
		this.electronicProducts = electronicProducts;
	}





	
}
