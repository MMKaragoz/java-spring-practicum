package com.mert.orderapp.client.dto.request;

import java.util.Objects;

import com.mert.orderapp.entity.enums.Sector;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateCompanyRequest {

	@NotBlank(message = "Company name is required.")
	@Size(min = 1, max = 100)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Sector sector;
	
	public UpdateCompanyRequest() {
		
	}

	public UpdateCompanyRequest(@NotBlank(message = "Company name is required.") @Size(min = 1, max = 100) String name,
			Sector sector) {
		super();
		this.name = name;
		this.sector = sector;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, sector);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdateCompanyRequest other = (UpdateCompanyRequest) obj;
		return Objects.equals(name, other.name) && sector == other.sector;
	}

	@Override
	public String toString() {
		return "UpdateCompanyRequest [name=" + name + ", sector=" + sector + "]";
	}
	
}
