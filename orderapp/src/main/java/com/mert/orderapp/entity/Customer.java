package com.mert.orderapp.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5267343083669620653L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@NotBlank(message = "Name is required.")
	@Size(min = 2, max = 100)
	private String name;
	
	@NotBlank(message = "Surname is required.")
	@Size(min = 2, max = 100)
	private String surname;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	@OneToMany(mappedBy = "customer")
	private List<Invoice> invoices;
	
	public Customer() {
		
	}

	public Customer(Date createdAt, Date updatedAt, String id,
			@NotBlank(message = "Name is required.") @Size(min = 2, max = 100) String name,
			@NotBlank(message = "Surname is required.") @Size(min = 2, max = 100) String surname, Company company,
			List<Invoice> invoices) {
		super(createdAt, updatedAt);
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.company = company;
		this.invoices = invoices;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(company, id, invoices, name, surname);
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
		Customer other = (Customer) obj;
		return Objects.equals(company, other.company) && Objects.equals(id, other.id)
				&& Objects.equals(invoices, other.invoices) && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", company=" + company + ", invoices="
				+ invoices + "]";
	}
	
}
