package com.pos.company.repository;

import org.springframework.stereotype.Repository;

import com.pos.base.repository.GenericRepository;
import com.pos.company.entity.User;

@Repository
public interface UserRepository extends GenericRepository<User, String>{

}
