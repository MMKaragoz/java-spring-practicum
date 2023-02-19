package com.mert.orderapp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mert.orderapp.client.dto.request.CreateInvoiceRequest;
import com.mert.orderapp.client.dto.request.UpdateInvoiceRequest;
import com.mert.orderapp.entity.Invoice;
import com.mert.orderapp.exception.NotFoundException;
import com.mert.orderapp.repository.InvoiceRepository;
import com.mert.orderapp.service.CustomerService;
import com.mert.orderapp.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	private final InvoiceRepository invoiceRepository;
	private final ModelMapper modelMapper;
	private final CustomerService customerService;
	
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository, ModelMapper modelMapper, CustomerService customerService) {
		this.invoiceRepository = invoiceRepository;
		this.modelMapper = modelMapper;
		this.customerService = customerService;
	}
	
	@Override
	public Invoice create(CreateInvoiceRequest createInvoiceRequest) {
		Invoice invoice = modelMapper.map(createInvoiceRequest, Invoice.class);
		Invoice createdInvoice = invoiceRepository.save(invoice);
		
		return createdInvoice;
	}
	
	@Override
	public List<Invoice> getAll(Optional<BigDecimal> greaterThan) {
		List<Invoice> invoices = new ArrayList<>();
		
		if(greaterThan.isPresent()) {
			invoices = invoiceRepository.findByAmountGreaterThan(greaterThan);
		} else {
			invoices = invoiceRepository.findAll();
		}
		
		return invoices;
	}
	
	protected Invoice findById(String id) {
		Invoice invoice = invoiceRepository.findById(id)
							.orElseThrow(
									() -> new NotFoundException("Invoice could not find by " + id));
		
		return invoice;
	}

	@Override
	public Invoice getById(String id) {
		return findById(id);
	}

	@Override
	public Invoice updateById(String id, UpdateInvoiceRequest updateInvoiceRequest) {
		Invoice invoice = findById(id);
		invoice.setAmount(updateInvoiceRequest.getAmount());
		invoice.setCustomer(customerService.getById(updateInvoiceRequest.getCustomerId()));
		Invoice updatedInvoice = invoiceRepository.save(invoice);
		
		return updatedInvoice;
	}

	@Override
	public void deleteById(String id) {
		findById(id);
		invoiceRepository.deleteById(id);
	}

}
