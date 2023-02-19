package com.mert.orderapp.service.impl;

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
