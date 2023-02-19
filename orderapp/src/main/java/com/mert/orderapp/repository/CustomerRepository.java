package com.mert.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mert.orderapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
