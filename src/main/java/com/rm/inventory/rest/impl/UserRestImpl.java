package com.rm.inventory.rest.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.rm.inventory.constents.InventoryConstents;
import com.rm.inventory.rest.UserRest;
import com.rm.inventory.service.UserService;
import com.rm.inventory.utils.InventoryUtils;

@RestController
public class UserRestImpl implements UserRest{

	@Autowired
	private UserService userService;
	
	@Override
	public ResponseEntity<String> SignUp(Map<String, String> requestMap) {
		try {
			return userService.signUp(requestMap);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return InventoryUtils.getResponseEntiry(InventoryConstents.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
