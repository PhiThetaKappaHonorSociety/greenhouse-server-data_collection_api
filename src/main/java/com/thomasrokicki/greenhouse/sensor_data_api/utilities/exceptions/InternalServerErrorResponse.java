package com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorResponse extends Exception {

	private static final long serialVersionUID = 1L;

	public InternalServerErrorResponse(String message, Exception exception) {
		super(message, exception);
	}

	public InternalServerErrorResponse(String message) {
		super(message);
	}

	public InternalServerErrorResponse() {
		super("Something went wrong on the server side");
	}

}
