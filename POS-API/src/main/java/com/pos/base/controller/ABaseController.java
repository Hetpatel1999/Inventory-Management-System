package com.pos.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.pos.base.dto.ResponseDTO;

public abstract class ABaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getControllerClass());
	
	public abstract Class<?> getControllerClass();

	
	/**
	 * It will create response based on given information.
	 * 
	 * @param body
	 * @param httpStatus
	 * @return
	 */
	protected <T> ResponseDTO<T> generateResponse(T body, HttpStatus httpStatus) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json");
		return new ResponseDTO<T>(body, responseHeaders, httpStatus);
	}

}
