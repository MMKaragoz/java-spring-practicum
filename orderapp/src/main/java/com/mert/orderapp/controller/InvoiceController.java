package com.mert.orderapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mert.orderapp.service.InvoiceService;

@RestController
@RequestMapping("api/v1/invoice")
public class InvoiceController {

	private final InvoiceService invoiceService;
	
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
}
