package com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiResponseNotFoundError extends Exception {

	private static final long serialVersionUID = 1L;

	public ApiResponseNotFoundError(String message, Exception exception) {
		super(message, exception);
	}

	public ApiResponseNotFoundError(String message) {
		super(message);
	}

	public ApiResponseNotFoundError() {
		super("Could not find what you are requesting, is the ID correct?");
	}

}
