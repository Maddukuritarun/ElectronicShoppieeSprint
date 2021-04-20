package com.cg.es.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.es.entity.CustomerEntity;
import com.cg.es.exception.CustomerNotFoundException;
import com.cg.es.model.BasketModel;
import com.cg.es.model.CustomerModel;
import com.cg.es.model.ElectronicProductModel;
import com.cg.es.model.ManagerModel;
import com.cg.es.repository.BasketRepository;
import com.cg.es.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private EMParser parser;
	@Autowired
	private BasketRepository basketRepo;
	
	public CustomerServiceImpl() {
		
	}
	
	public CustomerServiceImpl(CustomerRepository custRepo, EMParser parser) {
		super();
		this.custRepo = custRepo;
		this.parser = new EMParser();
	}
	

	public CustomerRepository getCustRepo() {
		return custRepo;
	}

	public void setCustRepo(CustomerRepository custRepo) {
		this.custRepo = custRepo;
	}

	public EMParser getParser() {
		return parser;
	}

	public void setParser(EMParser parser) {
		this.parser = parser;
	}

	@Override
	public CustomerModel addCustomer(CustomerModel customerModel) throws CustomerNotFoundException {
		if (customerModel != null) {
			if (custRepo.existsById(customerModel.getCustomerId())) {
				throw new CustomerNotFoundException("Customer with Id " + customerModel.getCustomerId() + " is exist already");
			} else if ((custRepo).existsByCustomerPhone(customerModel.getCustomerPhone())) {
				throw new CustomerNotFoundException("Customer with mobile number " + customerModel.getCustomerPhone() + " is exist already");
			} else if (custRepo.existsByCustomerEmail(customerModel.getCustomerEmail())) {
				throw new CustomerNotFoundException("Customer with email " + customerModel.getCustomerEmail() + " is exist already");
			} else {
				customerModel = parser.parse(custRepo.save(parser.parse(customerModel)));
			}
		}
		BasketModel bas=new BasketModel(null, null, null,customerModel.getCustomerId());
		parser.parse(basketRepo.save(parser.parse(bas)));
		return customerModel;
	}


	@Override
	public void deleteById(Long customerId) {
		custRepo.deleteById(customerId);
		
	}
	
	@Override
	public CustomerModel findById(Long customerId) {
		return parser.parse(custRepo.findById(customerId).orElse(null));
	}

	@Override
	public CustomerModel updateCustomer(CustomerModel customerModel, Long customerId) throws CustomerNotFoundException {
		if(customerModel != null) {
			if(!custRepo.existsById(customerId)) {
				throw new CustomerNotFoundException("no such id");
				}
			customerModel = parser.parse(custRepo.save(parser.parse(customerModel)));
			}
		return customerModel;
		}
	
	
	

	@Override
	public boolean existsByCustomerPhone(String customerPhone) {
		return custRepo.existsByCustomerPhone(customerPhone);
	}





	@Override
	public boolean existsByCustomerEmail(String customerEmail) {
		return custRepo.existsByCustomerEmail(customerEmail);
	}



	@Override
	public List<CustomerModel> findAll() {
		// TODO Auto-generated method stub
		return custRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	
}