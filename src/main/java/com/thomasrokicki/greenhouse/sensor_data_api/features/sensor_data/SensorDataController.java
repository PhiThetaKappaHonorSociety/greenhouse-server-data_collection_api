package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thomasrokicki.greenhouse.sensor_data_api.features.api_token.ApiTokenService;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages.SensorDataMessageCreateRequest;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages.SensorDataMessageCreateResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages.SensorDataMessageGetResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.ApiResponseNotFoundError;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.BadRequestErrorResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.InternalServerErrorResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.UnauthorizedErrorResponse;

@RestController
@RequestMapping(value = "/api/v1/sensor-data", produces = MediaType.APPLICATION_JSON_VALUE)
public class SensorDataController {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private ApiTokenService apiTokenService;
	
	@Autowired
	private SensorDataService sensorDataService;

	@RequestMapping(method = RequestMethod.POST)
	public SensorDataMessageCreateResponse createSensorData(@RequestHeader("X-API-KEY") String authHeader,
			@RequestBody SensorDataMessageCreateRequest body)
			throws InternalServerErrorResponse, BadRequestErrorResponse, UnauthorizedErrorResponse, ApiResponseNotFoundError {
		final String methodLabel = "In createSensorData(): ";
		logger.debug(methodLabel + "Hit");

		apiTokenService.validateApiToken(authHeader);

		return sensorDataService.create(body);

	}
	
	@RequestMapping(value = "/{sensor-uuid}/latest", method = RequestMethod.GET)
	public SensorDataMessageGetResponse getLatest(@RequestHeader("X-API-KEY") String authHeader,
			@PathVariable(value = "sensor-uuid") String sensorUuid) throws UnauthorizedErrorResponse, ApiResponseNotFoundError {
		final String methodLabel = "In getLatest(): ";
		logger.debug(methodLabel + "Hit");

		apiTokenService.validateApiToken(authHeader);

		return sensorDataService.getMostRecentDataBySensorUuid(sensorUuid);

	}
}
