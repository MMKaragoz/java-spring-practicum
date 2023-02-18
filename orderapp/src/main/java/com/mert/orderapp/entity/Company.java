package com.mert.orderapp.entity;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.mert.orderapp.entity.enums.Sector;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
	
	@NotBlank(message = "Company name is required.")
	@Size(min = 1, max = 100)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Sector sector;
	
	@OneToMany(mappedBy = "company")
	private List<Customer> customers;
}
