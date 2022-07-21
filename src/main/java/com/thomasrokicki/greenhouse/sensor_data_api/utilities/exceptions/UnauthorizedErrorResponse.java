package com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedErrorResponse extends Exception {

	private static final long serialVersionUID = 1L;

	public UnauthorizedErrorResponse(String message, Exception exception) {
		super(message, exception);
	}

	public UnauthorizedErrorResponse(String message) {
		super(message);
	}

	public UnauthorizedErrorResponse() {
		super("Please provide a valid 'X-API-KEY' header'");
	}

}
