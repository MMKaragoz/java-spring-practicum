package com.mert.orderapp.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mert.orderapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	@Query("SELECT c FROM Customer c WHERE LOWER(c.name) LIKE %:contains%")
	List<Customer> findByNameContains(Optional<String> contains);
	
	@Query("SELECT c FROM Customer c WHERE MONTHNAME(c.createdAt) = :creationMonth")
	List<Customer> findByCreationMonth(Optional<String> creationMonth);

	@Query("SELECT c FROM Customer c WHERE LOWER(c.name) LIKE %:contains% AND MONTHNAME(c.createdAt) = :creationMonth")
	List<Customer> findByNameContainsAndCreationMonth(Optional<String> contains, Optional<String> creationMonth);

	List<Customer> findByInvoicesAmountLessThan(BigDecimal amount);
}
