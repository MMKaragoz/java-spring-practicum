package com.mert.orderapp.service;

import com.mert.orderapp.client.dto.request.CreateCustomerRequest;
import com.mert.orderapp.client.dto.request.UpdateCustomerRequest;
import com.mert.orderapp.entity.Customer;

public interface CustomerService {

	Customer create(CreateCustomerRequest createCustomerRequest);
	
	Customer getById(String id);
	
	Customer updateById(String id, UpdateCustomerRequest updateCustomerRequest);
	
	void deleteById(String id);
}
