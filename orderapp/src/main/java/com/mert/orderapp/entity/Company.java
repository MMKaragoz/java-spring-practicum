package com.mert.orderapp.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;

import com.mert.orderapp.entity.enums.Sector;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "company")
public class Company extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3638883176110651355L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@NotNull(message = "Company name is required.")
	@Size(min = 1, max = 100)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Sector sector;
	
	@OneToMany(mappedBy = "company")
	private List<Customer> customers;
	
	public Company() {
		
	}

	public Company(Date createdAt, Date updatedAt, String id,
			@NotNull(message = "Company name is required.") @Size(min = 1, max = 100) String name, Sector sector,
			List<Customer> customers) {
		super(createdAt, updatedAt);
		this.id = id;
		this.name = name;
		this.sector = sector;
		this.customers = customers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(customers, id, name, sector);
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
		Company other = (Company) obj;
		return Objects.equals(customers, other.customers) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && sector == other.sector;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", sector=" + sector + ", customers=" + customers + "]";
	}
	
}
