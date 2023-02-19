package com.mert.orderapp.client.dto.response;

import java.util.List;
import java.util.Objects;

import com.mert.orderapp.entity.Invoice;

public class CustomerDto {

	private String name;
	
	private String surname;
	
	private List<Invoice> invoices;
	
	public CustomerDto() {
		
	}

	public CustomerDto(String name, String surname, List<Invoice> invoices) {
		this.name = name;
		this.surname = surname;
		this.invoices = invoices;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public int hashCode() {
		return Objects.hash(invoices, name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDto other = (CustomerDto) obj;
		return Objects.equals(invoices, other.invoices) && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", surname=" + surname + ", invoices=" + invoices + "]";
	}

	
}
