package com.cg.es.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.es.entity.BasketEntity;
import com.cg.es.entity.CustomerEntity;
import com.cg.es.entity.ElectronicProductEntity;
import com.cg.es.entity.ElectronicProductOrderEntity;
import com.cg.es.entity.Manager;
import com.cg.es.entity.User;
import com.cg.es.model.BasketModel;
import com.cg.es.model.CustomerModel;
import com.cg.es.model.ElectronicProductModel;
import com.cg.es.model.ElectronicProductOrderModel;
import com.cg.es.model.ManagerModel;
import com.cg.es.model.ProductType;
import com.cg.es.model.UserModel;
import com.cg.es.model.UserType;
import com.cg.es.repository.CustomerRepository;
import com.cg.es.repository.ElectronicProductRepository;

@Service
public class EMParser {
	
	@Autowired
	private CustomerRepository customerRepo;
	
//	@Autowired
//	private ManagerRepository managerRepo;
//	
//	@Autowired
//	private BasketRepository basketRepo;
//	
//	@Autowired
//	private ElectronicProductOrderRepository electronicproductorderrepo;
	@Autowired
	private ElectronicProductRepository epo;

	
	public CustomerModel parse(CustomerEntity source) {
		return source == null ? null
				: new CustomerModel(source.getCustomerId(),
						source.getCustomerName(),
						source.getCustomerPassword(),
						source.getCustomerEmail(),
						source.getCustomerPhone(),
						source.getAddress());
	}

	public CustomerEntity parse(CustomerModel source) {
		return source == null ? null
				: new CustomerEntity(source.getCustomerId(),
						source.getCustomerName(),
						source.getCustomerPassword(),
						source.getCustomerEmail(),
						source.getCustomerPhone(),
						source.getAddress());
	}
	
	
	public ManagerModel parse(Manager source) {
		return source == null ? null
				: new ManagerModel(source.getManagerId(),
						source.getPassword());
	}
	
	public Manager parse(ManagerModel source) {
		return source == null ? null
				: new Manager(source.getManagerId(),
						source.getPassword());
	}
	
	public ElectronicProductModel parse(ElectronicProductEntity source) {
		return source == null ? null
				: new ElectronicProductModel(source.getProductId(),
						source.getProductName(),
						source.getProductPrice(),
						source.getCreatedDate(),
						String.valueOf(source.getProductType()));
	}

	
	 
	 public ElectronicProductEntity parse(ElectronicProductModel source) { 
		 return source==null?null:
			 new  ElectronicProductEntity(source.getProductId(),
						source.getProductName(),
						source.getProductPrice(),
						source.getCreatedDate(),
						ProductType.valueOf(source.getProductType()));
							 
	 }
	
	public ElectronicProductOrderModel parse(ElectronicProductOrderEntity source) {
		return source == null ? null
				: new ElectronicProductOrderModel(source.getOrderId(),
						source.getProductQty(),
						source.getOrderDate(),
						source.getAmount(),
						source.getCustomer().getCustomerId());
	}
	
	public ElectronicProductOrderEntity parse(ElectronicProductOrderModel source) {
		return source == null ? null
				: new ElectronicProductOrderEntity(source.getCustomerId(),
						source.getProductQty(),
						source.getOrderDate(),
						source.getAmount(),
						customerRepo.findById(source.getCustomerId()).orElse(null));
	}
	
	public BasketModel parse(BasketEntity source) {
		List<Long> epe = new ArrayList<>();
		if(source.getElectronicProduct() != null) {
		for(ElectronicProductEntity l : source.getElectronicProduct()) {
			epe.add(l.getProductId());
		}
		}
		BasketModel bm = new BasketModel(source.getBasketId(),
				source.getGrandTotal(),
				source.getQuantityOfProduct(),
//				source.getElectronicProduct(),
				source.getCustomer().getCustomerId());
		bm.setElectronicProduct(epe);
		return source == null ? null
				: bm;
	}
	
	public BasketEntity parse(BasketModel source) {
		List<ElectronicProductEntity> epe = new ArrayList<>();
		double gt=0;
		int qty=0;
		if(source.getElectronicProduct()!=null) {
		for(long l : source.getElectronicProduct()) {
			ElectronicProductEntity ep = epo.findById(l).get();
			gt+=ep.getProductPrice();
			qty++;
			epe.add(ep);
		}
		}
		BasketEntity be = new BasketEntity(source.getBasketId(),
				qty,
				gt,
				customerRepo.findById(source.getCustomerId()).orElse(null));
		be.setElectronicProduct(epe);
				
		return source == null ? null
				: be;
	}
	
	public UserModel parse(User source) {
		return source == null?null:
			new UserModel(source.getUserName(),
					source.getUserPassword(),source.getUserType().name());
	}
	
	public User parse(UserModel source) {
		return source == null?null:
			new User(source.getUserName(),
					source.getUserPassword(),
					UserType.valueOf(source.getUserType()));
	}
	

}