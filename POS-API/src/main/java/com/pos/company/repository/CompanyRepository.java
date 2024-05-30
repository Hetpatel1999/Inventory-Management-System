package com.pos.company.repository;

import org.springframework.stereotype.Repository;

import com.pos.base.repository.GenericRepository;
import com.pos.company.entity.Company;

@Repository
public interface CompanyRepository extends GenericRepository<Company, String> {
}
