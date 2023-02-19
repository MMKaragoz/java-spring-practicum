package com.mert.orderapp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mert.orderapp.client.dto.request.CreateCompanyRequest;
import com.mert.orderapp.client.dto.request.UpdateCompanyRequest;
import com.mert.orderapp.entity.Company;
import com.mert.orderapp.exception.NotFoundException;
import com.mert.orderapp.repository.CompanyRepository;
import com.mert.orderapp.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	private final ModelMapper modelMapper;
	private final CompanyRepository companyRepository;
	
	public CompanyServiceImpl(ModelMapper modelMapper, CompanyRepository companyRepository) {
		this.modelMapper = modelMapper;
		this.companyRepository = companyRepository;
	}

	@Override
	public Company create(CreateCompanyRequest createCompanyRequest) {
		
		Company company = modelMapper.map(createCompanyRequest, Company.class);
		Company createdCompany = companyRepository.save(company);
		
		return createdCompany;
	}
	
	protected Company findById(String id) {
		Company company = companyRepository.findById(id)
							.orElseThrow(
									() -> new NotFoundException("Company could not find by " + id));
		
		return company;
	}

	@Override
	public Company getById(String id) {
		
		return findById(id);
	}

	@Override
	public Company updateById(String id, UpdateCompanyRequest updateCompanyRequest) {
		
		Company company = findById(id);
		company.setName(updateCompanyRequest.getName());
		company.setSector(updateCompanyRequest.getSector());
		Company updatedCompany = companyRepository.save(company);
		
		return updatedCompany;
	}

	@Override
	public void deleteById(String id) {
		findById(id);
		companyRepository.deleteById(id);
	}

}
