package com.rm.inventory.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/user")
public interface UserRest {
	
	@PostMapping(path = "/signup")
	public ResponseEntity<String> SignUp(@RequestBody (required = true) Map<String, String> requestMap);

}