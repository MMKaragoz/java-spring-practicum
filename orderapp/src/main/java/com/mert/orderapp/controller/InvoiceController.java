package com.mert.orderapp.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mert.orderapp.client.dto.request.CreateInvoiceRequest;
import com.mert.orderapp.client.dto.request.UpdateInvoiceRequest;
import com.mert.orderapp.client.dto.response.InvoiceDto;
import com.mert.orderapp.entity.Invoice;
import com.mert.orderapp.service.InvoiceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/invoice")
public class InvoiceController {

	private final InvoiceService invoiceService;
	private final ModelMapper modelMapper;
	
	public InvoiceController(InvoiceService invoiceService, ModelMapper modelMapper) {
		this.invoiceService = invoiceService;
		this.modelMapper = modelMapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<InvoiceDto> create(@Valid @RequestBody CreateInvoiceRequest createInvoiceRequest) {
		Invoice invoice = invoiceService.create(createInvoiceRequest);
		InvoiceDto response = modelMapper.map(invoice, InvoiceDto.class);
		System.out.println("here");
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InvoiceDto> getById(@PathVariable String id) {
		Invoice invoice = invoiceService.getById(id);
		InvoiceDto response = modelMapper.map(invoice, InvoiceDto.class);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<InvoiceDto> updateById(@PathVariable String id, @Valid @RequestBody UpdateInvoiceRequest updateInvoiceRequest) {
		Invoice invoice = invoiceService.updateById(id, updateInvoiceRequest);
		InvoiceDto response = modelMapper.map(invoice, InvoiceDto.class);
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable String id) {
		invoiceService.deleteById(id);
		String response = "Successfully deleted";
		
		return ResponseEntity.ok(response);
	}
}
