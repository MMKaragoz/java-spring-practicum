package com.mert.orderapp.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

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

	public Invoice() {
		
	}

	public Invoice(Date createdAt, Date updatedAt, String id,
			@Min(value = 0, message = "Loan amount cannot be negative") BigDecimal amount, Customer customer) {
		super(createdAt, updatedAt);
		this.id = id;
		this.amount = amount;
		this.customer = customer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(amount, customer, id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(customer, other.customer)
				&& Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", amount=" + amount + ", customer=" + customer + "]";
	}

}
