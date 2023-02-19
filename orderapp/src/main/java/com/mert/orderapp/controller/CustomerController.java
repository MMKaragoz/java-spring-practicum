package com.mert.orderapp.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mert.orderapp.client.dto.request.CreateCustomerRequest;
import com.mert.orderapp.client.dto.request.UpdateCustomerRequest;
import com.mert.orderapp.client.dto.response.CustomerDto;
import com.mert.orderapp.entity.Customer;
import com.mert.orderapp.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

	private final CustomerService customerService;
	private final ModelMapper modelMapper;
	
	public CustomerController(CustomerService customerService, ModelMapper modelMapper) {
		this.customerService = customerService;
		this.modelMapper = modelMapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CustomerDto> create(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
		Customer customer = customerService.create(createCustomerRequest);
		CustomerDto response = modelMapper.map(customer, CustomerDto.class);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping()
	public ResponseEntity<List<CustomerDto>> getAll(@RequestParam Optional<String> contains, @RequestParam Optional<String> creationMonth){
		List<Customer> customers = customerService.getAll(contains, creationMonth);
		List<CustomerDto> response = customers.stream().map(customer -> modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getById(@PathVariable String id) {
		Customer customer = customerService.getById(id);
		CustomerDto response = modelMapper.map(customer, CustomerDto.class);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDto> updateById(@PathVariable String id, @Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
		Customer customer = customerService.updateById(id, updateCustomerRequest);
		CustomerDto response = modelMapper.map(customer, CustomerDto.class);
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable String id) {
		customerService.deleteById(id);
		String response = "Successfully deleted";
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/query")
	public ResponseEntity<List<CustomerDto>> getAllByInvoicesAmount(@RequestParam("invoicesAmountLessThan") BigDecimal amount) {
		List<Customer> customers = customerService.getAllByInvoicesAmount(amount);
		List<CustomerDto> response = customers.stream().map(customer -> modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}
	
}
