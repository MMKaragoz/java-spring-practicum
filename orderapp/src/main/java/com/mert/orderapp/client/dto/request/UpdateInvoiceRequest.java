package com.mert.orderapp.client.dto.request;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.validation.constraints.Min;

public class UpdateInvoiceRequest {

	@Min(value = 0, message = "Loan amount cannot be negative")
	private BigDecimal amount;
	
	private String customerId;
	
	public UpdateInvoiceRequest() {
		
	}

	public UpdateInvoiceRequest(@Min(value = 0, message = "Loan amount cannot be negative") BigDecimal amount,
			String customerId) {
		this.amount = amount;
		this.customerId = customerId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, customerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdateInvoiceRequest other = (UpdateInvoiceRequest) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(customerId, other.customerId);
	}

	@Override
	public String toString() {
		return "UpdateInvoiceRequest [amount=" + amount + ", customerId=" + customerId + "]";
	}
	
}
