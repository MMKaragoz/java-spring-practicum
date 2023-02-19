package com.mert.orderapp.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mert.orderapp.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

	List<Invoice> findByAmountGreaterThan(Optional<BigDecimal> greaterThan);
	List<Invoice> findByAmountLessThan(Optional<BigDecimal> lessThan);
}
