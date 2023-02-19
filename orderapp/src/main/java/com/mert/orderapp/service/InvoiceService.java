package com.mert.orderapp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.mert.orderapp.client.dto.request.CreateInvoiceRequest;
import com.mert.orderapp.client.dto.request.UpdateInvoiceRequest;
import com.mert.orderapp.entity.Invoice;

public interface InvoiceService {

	Invoice create(CreateInvoiceRequest createInvoiceRequest);
	
	List<Invoice> getAll(Optional<BigDecimal> greaterThan);
	
	Invoice getById(String id);
	
	Invoice updateById(String id, UpdateInvoiceRequest updateInvoiceRequest);
	
	void deleteById(String id);
}
