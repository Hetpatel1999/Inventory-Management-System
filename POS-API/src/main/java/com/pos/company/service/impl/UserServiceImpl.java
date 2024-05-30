package com.pos.company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.company.entity.User;
import com.pos.company.repository.UserRepository;
import com.pos.company.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(String userId) {
		return userRepository.findById(userId);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User userDetails) {
		Optional<User> userDate = getUserById(userDetails.getId());
        if (userDate.isPresent()) {
            User updatedUser = userDate.get();
            updatedUser.setUsername(userDetails.getUsername());
            updatedUser.setPasswordHash(userDetails.getPasswordHash());
            updatedUser.setEmail(userDetails.getEmail());
            updatedUser.setRole(userDetails.getRole());
            saveUser(updatedUser);
        }
        else {
        	// Send user not found error
        }
        return userDetails;
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

}
