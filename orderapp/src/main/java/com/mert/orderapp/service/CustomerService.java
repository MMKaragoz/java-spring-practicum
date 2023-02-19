package com.mert.orderapp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.mert.orderapp.client.dto.request.CreateCustomerRequest;
import com.mert.orderapp.client.dto.request.UpdateCustomerRequest;
import com.mert.orderapp.entity.Customer;

public interface CustomerService {

	Customer create(CreateCustomerRequest createCustomerRequest);
	
	List<Customer> getAll(Optional<String> contains, Optional<String> createdIn);
	
	Customer getById(String id);
	
	Customer updateById(String id, UpdateCustomerRequest updateCustomerRequest);
	
	void deleteById(String id);
	
	List<Customer> getAllByInvoicesAmount(BigDecimal amount);
}
