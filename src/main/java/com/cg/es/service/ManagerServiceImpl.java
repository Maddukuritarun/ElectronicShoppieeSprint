package com.cg.es.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.es.entity.CustomerEntity;
import com.cg.es.entity.ElectronicProductEntity;
import com.cg.es.entity.ElectronicProductOrderEntity;
import com.cg.es.entity.Manager;
import com.cg.es.exception.ManagerNotFoundException;
import com.cg.es.model.CustomerModel;
import com.cg.es.model.ElectronicProductModel;
import com.cg.es.model.ElectronicProductOrderModel;
import com.cg.es.model.ManagerModel;
import com.cg.es.repository.CustomerRepository;
import com.cg.es.repository.ManagerRepository;
@Service
public class ManagerServiceImpl implements IManagerService{
	@Autowired
	private ManagerRepository managerRepo;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private EMParser parser;
	
	
	public ManagerServiceImpl() {
		super();
	}
	
	public ManagerServiceImpl(ManagerRepository managerRepo, EMParser parser) {
			super();
			this.managerRepo = managerRepo;
			this.parser = new EMParser();
			}
	
	@Override
	public ManagerModel addManager(ManagerModel managerModel) throws ManagerNotFoundException {
		if (managerModel != null) {
			if (managerRepo.existsById(managerModel.getManagerId())) {
				throw new ManagerNotFoundException("Manager with Id " + managerModel.getManagerId() + " is exist already");
				} else {
					managerModel = parser.parse(managerRepo.save((parser.parse(managerModel))));
					}
			}
		return managerModel;
	}
	
	
	@Override
	public ManagerModel updateManager(ManagerModel managerModel, Long managerId) throws ManagerNotFoundException {
		if(managerModel != null) {
			if(!managerRepo.existsById(managerId)) {
				throw new ManagerNotFoundException("no such id");
				}
			managerModel = parser.parse(managerRepo.save(parser.parse(managerModel)));
			}
		return managerModel;
	}
	
	@Override
	public void deleteById(Long managerId) {
		managerRepo.deleteById(managerId);
	}

	@Override
	public ManagerModel findById(Long managerId) {
		return parser.parse(managerRepo.findById(managerId).orElse(null));
	}

	@Override
	public List<ManagerModel> findAll() {
		return managerRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	

		
}