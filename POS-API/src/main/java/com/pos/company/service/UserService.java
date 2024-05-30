package com.pos.company.service;

import java.util.List;
import java.util.Optional;

import com.pos.company.entity.User;

public interface UserService {

    public List<User> getAllUsers() ;

    public Optional<User> getUserById(String userId);

    public User saveUser(User user);
    
    public User updateUser(User user);

    public void deleteUser(String userId);
    
}
