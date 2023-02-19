package com.mert.orderapp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mert.orderapp.client.dto.request.CreateCustomerRequest;
import com.mert.orderapp.client.dto.request.UpdateCustomerRequest;
import com.mert.orderapp.entity.Customer;
import com.mert.orderapp.exception.NotFoundException;
import com.mert.orderapp.repository.CustomerRepository;
import com.mert.orderapp.service.CompanyService;
import com.mert.orderapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	private final ModelMapper modelMapper;
	private final CustomerRepository customerRepository;
	private final CompanyService companyService;
	
	public CustomerServiceImpl(ModelMapper modelMapper, CustomerRepository customerRepository, CompanyService companyService) {
		this.modelMapper = modelMapper;
		this.customerRepository = customerRepository;
		this.companyService = companyService;
	}
	
	@Override
	public Customer create(CreateCustomerRequest createCustomerRequest) {
		Customer customer = modelMapper.map(createCustomerRequest, Customer.class);
		Customer createdCustomer = customerRepository.save(customer);
		
		return createdCustomer;
	}
	
	@Override
	public List<Customer> getAll(Optional<String> contains, Optional<String> creationMonth) {
		List<Customer> customers = new ArrayList<>();
		
		if (contains.isPresent() && creationMonth.isPresent()) {
			customers = customerRepository.findByNameContainsAndCreationMonth(contains, creationMonth);
		}else if(creationMonth.isPresent()) {
			customers = customerRepository.findByCreationMonth(creationMonth);
		} else if(contains.isPresent()) {
				customers = customerRepository.findByNameContains(contains);
		} else {
			customers = customerRepository.findAll();
		}
		return customers;
	}
	
	protected Customer findById(String id) {
		Customer customer = customerRepository.findById(id)
							.orElseThrow(
									() -> new NotFoundException("Customer could not find by " + id));
		
		return customer;
	}

	@Override
	public Customer getById(String id) {
		return findById(id);
	}

	@Override
	public Customer updateById(String id, UpdateCustomerRequest updateCustomerRequest) {
		Customer customer = findById(id);
		customer.setName(updateCustomerRequest.getName());
		customer.setSurname(updateCustomerRequest.getSurname());
		customer.setCompany(companyService.getById(updateCustomerRequest.getCompanyId()));
		Customer updatedCustomer = customerRepository.save(customer);
		
		return updatedCustomer;
	}

	@Override
	public void deleteById(String id) {
		findById(id);
		customerRepository.deleteById(id);
	}

	@Override
	public List<Customer> getAllByInvoicesAmount(BigDecimal amount) {
		List<Customer> customers = customerRepository.findByInvoicesAmountLessThan(amount);
		return customers;
	}

}
