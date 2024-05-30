package com.pos.base.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This controller is responsible Ping dealer whether it is login or not.
 * 
 * @author Moti Prajapati
 *
 */

@Controller
@RequestMapping("/api/v1")
public class PingController extends ABaseController {

	/**
	 * Check whether user login or not .
	 * 
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void ping() throws Throwable {
	}

	/**
	 * Check whether user login or not .
	 * 
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/health-check", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String apiHealthCheckPing() throws Throwable {
		logger.debug("Health Check API Call");
		return "SUCCESS";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<?> getControllerClass() {
		return this.getClass();
	}

}

