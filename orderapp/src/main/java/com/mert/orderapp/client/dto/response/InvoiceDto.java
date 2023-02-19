package com.mert.orderapp.client.dto.response;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceDto {

	private BigDecimal amount;
	
	public InvoiceDto() {
		
	}

	public InvoiceDto(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceDto other = (InvoiceDto) obj;
		return Objects.equals(amount, other.amount);
	}

	@Override
	public String toString() {
		return "InvoiceDto [amount=" + amount + "]";
	}

	
}
