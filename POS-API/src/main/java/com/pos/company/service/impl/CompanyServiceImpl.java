package com.pos.company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.company.entity.Company;
import com.pos.company.repository.CompanyRepository;
import com.pos.company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
    private CompanyRepository companyRepository;

	@Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

	@Override
    public Optional<Company> getCompanyById(String companyId) {
        return companyRepository.findById(companyId);
    }

	@Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

	@Override
    public void deleteCompany(String companyId) {
        companyRepository.deleteById(companyId);
    }

}
