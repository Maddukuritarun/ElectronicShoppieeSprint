package com.cg.es.service;

import java.util.List;

import com.cg.es.exception.ElectronicProductNotFoundException;
import com.cg.es.model.ElectronicProductModel;

public interface IElectronicProductService {
	ElectronicProductModel addProduct(ElectronicProductModel electronicProductModel) throws ElectronicProductNotFoundException;
	ElectronicProductModel updateProduct(ElectronicProductModel electronicProductModel,Long productId) throws ElectronicProductNotFoundException;
	void deleteByProductId(Long productId);
	ElectronicProductModel findByProductId(Long productId);
	List<ElectronicProductModel> findAll();
//	List<ElectronicProductModel> findAllByCustomerId(Long customerId);
	

}
