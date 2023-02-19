package com.mert.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mert.orderapp.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
