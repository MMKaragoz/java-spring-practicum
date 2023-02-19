package com.mert.orderapp.service;

import com.mert.orderapp.client.dto.request.CreateCompanyRequest;
import com.mert.orderapp.client.dto.request.UpdateCompanyRequest;
import com.mert.orderapp.entity.Company;

public interface CompanyService {

	Company create(CreateCompanyRequest createCompanyRequest);
	
	Company getById(String id);
	
	Company updateById(String id, UpdateCompanyRequest updateCompanyRequest);
	
	void deleteById(String id);
	
}
