package com.mert.orderapp.client.dto.response;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.mert.orderapp.entity.enums.Sector;

public class CompanyDto extends BaseEntityDto {

	private String name;
	
	private Sector sector;
	
	private List<CustomerDto> customers;
	
	public CompanyDto() {
		
	}

	public CompanyDto(Date createdAt, Date updatedAt, String name, Sector sector, List<CustomerDto> customers) {
		super(createdAt, updatedAt);
		this.name = name;
		this.sector = sector;
		this.customers = customers;
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

	public List<CustomerDto> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerDto> customers) {
		this.customers = customers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(customers, name, sector);
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
		CompanyDto other = (CompanyDto) obj;
		return Objects.equals(customers, other.customers) && Objects.equals(name, other.name) && sector == other.sector;
	}

	@Override
	public String toString() {
		return "CompanyDto [name=" + name + ", sector=" + sector + ", customers=" + customers + "]";
	}
	
}
