package com.thomasrokicki.greenhouse.sensor_data_api.features.api_token;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.UnauthorizedErrorResponse;

public class ApiTokenService {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private ApiTokenRepository apiTokenRepository;

	public void validateApiToken(String apiToken) throws UnauthorizedErrorResponse {

		ApiTokenDao apiTokenDao = apiTokenRepository.findByApiToken(apiToken);

		if (apiTokenDao == null || apiTokenDao.getIsActive() == false) {
			logger.debug("Token is INVALID");
			throw new UnauthorizedErrorResponse();
		}

		logger.debug("Token is VALID");
	}
}
