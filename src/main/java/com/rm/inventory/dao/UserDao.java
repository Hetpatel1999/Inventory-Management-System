package com.rm.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rm.inventory.pojo.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{

	public User findByEmail(@Param("email")String email);

}
