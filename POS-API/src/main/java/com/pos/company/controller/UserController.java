package com.pos.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pos.base.controller.ABaseController;
import com.pos.base.dto.ResponseDTO;
import com.pos.company.entity.User;
import com.pos.company.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController extends ABaseController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseDTO<User> getUserById(@PathVariable String id) {
		Optional<User> user = userService.getUserById(id);
		return generateResponse(user.get(), HttpStatus.OK);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping()
	public ResponseDTO<User> updateUser(@RequestBody User userDetails) {
		return generateResponse(userService.updateUser(userDetails), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}

	@Override
	public Class<?> getControllerClass() {
		return this.getClass();
	}
}