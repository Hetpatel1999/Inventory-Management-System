package com.rm.inventory.service.impl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rm.inventory.constents.InventoryConstents;
import com.rm.inventory.dao.UserDao;
import com.rm.inventory.pojo.User;
import com.rm.inventory.service.UserService;
import com.rm.inventory.utils.InventoryUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		log.info("Insife Signup service:{}", requestMap);
		try {
			if (validateSignUpMap(requestMap)) {
				User user = userDao.findByEmail(requestMap.get("email"));
				if (Objects.isNull(user)) {
					userDao.save(getUserFromMap(requestMap));
					return InventoryUtils.getResponseEntiry(InventoryConstents.SUCCESSFULLY_REGISTRED, HttpStatus.OK);
				} else {
					return InventoryUtils.getResponseEntiry(InventoryConstents.EMAIL_ALREADY_EXITS,
							HttpStatus.BAD_REQUEST);
				}
			} else {
				return InventoryUtils.getResponseEntiry(InventoryConstents.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return InventoryUtils.getResponseEntiry(InventoryConstents.SOMETHING_WENT_WRONG,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private boolean validateSignUpMap(Map<String, String> requestMap) {
		return (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
				&& requestMap.containsKey("email") && requestMap.containsKey("password"));
	}

	private User getUserFromMap(Map<String, String> requestMap) {
		User user = new User();
		user.setName(requestMap.get("name"));
		user.setEmail(requestMap.get("email"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setPassword(requestMap.get("password"));
		user.setRole("user");
		user.setStatus("false");
		return user;
	}

}
