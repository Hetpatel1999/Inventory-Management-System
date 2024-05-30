package com.pos.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.base.controller.ABaseController;
import com.pos.base.dto.ResponseDTO;
import com.pos.company.entity.Company;
import com.pos.company.service.CompanyService;

@RestController
@RequestMapping(value = "/api/v1/companies")
public class CompanyController extends ABaseController {

	@Autowired
	private CompanyService companyService;

	@GetMapping
	public List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
	}

	@GetMapping("/{id}")
	public ResponseDTO<Optional<Company>> getCompanyById(@PathVariable String id) {
		Optional<Company> company = companyService.getCompanyById(id);
		return generateResponse(company, HttpStatus.OK);
	}

	@PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable String id, @RequestBody Company companyDetails) {
        Optional<Company> company = companyService.getCompanyById(id);
        if (company.isPresent()) {
            Company updatedCompany = company.get();
            updatedCompany.setName(companyDetails.getName());
            updatedCompany.setAddress(companyDetails.getAddress());
            updatedCompany.setEmail(companyDetails.getEmail());
            updatedCompany.setPhone(companyDetails.getPhone());
            return ResponseEntity.ok(companyService.saveCompany(updatedCompany));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable String id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

	@Override
	public Class<?> getControllerClass() {
		return this.getClass();
	}

}
