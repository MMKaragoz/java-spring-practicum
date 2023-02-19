package com.mert.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mert.orderapp.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

}
