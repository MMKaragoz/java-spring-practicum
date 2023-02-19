package com.mert.orderapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mert.orderapp.client.dto.request.CreateCompanyRequest;
import com.mert.orderapp.client.dto.request.UpdateCompanyRequest;
import com.mert.orderapp.client.dto.response.CompanyDto;
import com.mert.orderapp.entity.Company;
import com.mert.orderapp.service.CompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/company")
public class CompanyController {

	private final CompanyService companyService;
	private final ModelMapper modelMapper;
	
	public CompanyController(CompanyService companyService, ModelMapper modelMapper) {
		this.companyService = companyService;
		this.modelMapper = modelMapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CompanyDto> create(@Valid @RequestBody CreateCompanyRequest createCompanyRequest) {
		Company company = companyService.create(createCompanyRequest);
		CompanyDto response = modelMapper.map(company, CompanyDto.class);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> getById(@PathVariable String id) {
		Company company = companyService.getById(id);
		CompanyDto response = modelMapper.map(company, CompanyDto.class);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> updateById(@PathVariable String id, @Valid @RequestBody UpdateCompanyRequest updateCompanyRequest) {
		Company company = companyService.updateById(id, updateCompanyRequest);
		CompanyDto response = modelMapper.map(company, CompanyDto.class);
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable String id) {
		companyService.deleteById(id);
		String response = "Successfully deleted";
		
		return ResponseEntity.ok(response);
	}
}
