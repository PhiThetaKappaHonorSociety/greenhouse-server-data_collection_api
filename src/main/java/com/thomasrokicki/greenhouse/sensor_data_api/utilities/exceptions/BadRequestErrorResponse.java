package com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestErrorResponse extends Exception {

	private static final long serialVersionUID = 1L;

	public BadRequestErrorResponse(String message, Exception exception) {
		super(message, exception);
	}

	public BadRequestErrorResponse(String message) {
		super(message);
	}

	public BadRequestErrorResponse() {
		super("Something is wrong with your request");
	}

}
