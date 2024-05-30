package com.pos.company.service;

import java.util.List;
import java.util.Optional;

import com.pos.company.entity.Company;

/**
 * This service is related to {@link Company}
 * @author Het Patel
 *
 */
public interface CompanyService {

	public List<Company> getAllCompanies();

	public Optional<Company> getCompanyById(String companyId);

	public Company saveCompany(Company company);

	public void deleteCompany(String companyId);
}
