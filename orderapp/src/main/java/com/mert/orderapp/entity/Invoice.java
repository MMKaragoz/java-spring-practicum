package com.mert.orderapp.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "invoice")
public class Invoice extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 636358853279331999L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Min(value = 0, message = "Loan amount cannot be negative")
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

}
