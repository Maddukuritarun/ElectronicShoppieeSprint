package com.cg.es.service;

import java.util.List;

import com.cg.es.exception.ElectronicProductOrderNotFoundException;
import com.cg.es.model.ElectronicProductOrderModel;

public interface IElectronicProductOrderService {
	ElectronicProductOrderModel addOrder(ElectronicProductOrderModel electronicProductOrderModel) throws ElectronicProductOrderNotFoundException;
	ElectronicProductOrderModel updateOrder(ElectronicProductOrderModel electronicProductOrderModel,Long orderId) throws ElectronicProductOrderNotFoundException;
	void deleteByOrderId(Long orderId);
	ElectronicProductOrderModel findByOrderId(Long orderId);
	List<ElectronicProductOrderModel> findAll();
//	List<ElectronicProductOrderModel> findAllByCustomerId(Long customerId);
	

}
