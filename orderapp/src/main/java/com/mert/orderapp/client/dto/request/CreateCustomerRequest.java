package com.mert.orderapp.client.dto.request;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateCustomerRequest {

	@NotBlank(message = "Name is required.")
	@Size(min = 2, max = 100)
	private String name;
	
	@NotBlank(message = "Surname is required.")
	@Size(min = 2, max = 100)
	private String surname;
	
	private String companyId;
	
	public CreateCustomerRequest() {
		
	}

	public CreateCustomerRequest(@NotBlank(message = "Name is required.") @Size(min = 2, max = 100) String name,
			@NotBlank(message = "Surname is required.") @Size(min = 2, max = 100) String surname, String companyId) {
		this.name = name;
		this.surname = surname;
		this.companyId = companyId;
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

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyId, name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateCustomerRequest other = (CreateCustomerRequest) obj;
		return Objects.equals(companyId, other.companyId) && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "CreateCustomerRequest [name=" + name + ", surname=" + surname + ", companyId=" + companyId + "]";
	}
	
	
}
