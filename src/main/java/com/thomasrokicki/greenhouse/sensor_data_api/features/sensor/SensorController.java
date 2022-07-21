package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor;

import java.lang.invoke.MethodHandles;
import java.util.List;

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
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.messages.SensorMessageCreateRequest;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.messages.SensorMessageCreateResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.ApiResponseNotFoundError;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.BadRequestErrorResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.InternalServerErrorResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.UnauthorizedErrorResponse;

@RestController
@RequestMapping(value = "/api/v1/sensors", produces = MediaType.APPLICATION_JSON_VALUE)
public class SensorController {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private ApiTokenService apiTokenService;

	@Autowired
	private SensorService sensorService;

	@RequestMapping(method = RequestMethod.POST)
	public SensorMessageCreateResponse addSensor(@RequestHeader("X-API-KEY") String authHeader,
			@RequestBody SensorMessageCreateRequest body)
			throws InternalServerErrorResponse, BadRequestErrorResponse, UnauthorizedErrorResponse {
		final String methodLabel = "In addSensor(): ";
		logger.debug(methodLabel + "Hit");

		apiTokenService.validateApiToken(authHeader);

		return sensorService.add(body);

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<SensorMessageCreateResponse> getManySensors(@RequestHeader("X-API-KEY") String authHeader)
			throws UnauthorizedErrorResponse, ApiResponseNotFoundError {
		final String methodLabel = "In getManySensors(): ";
		logger.debug(methodLabel + "Hit");

		apiTokenService.validateApiToken(authHeader);

		return sensorService.findMany();

	}

	@RequestMapping(value = "/{sensor-uuid}", method = RequestMethod.GET)
	public SensorMessageCreateResponse getSensor(@RequestHeader("X-API-KEY") String authHeader,
			@PathVariable(value = "sensor-uuid") String sensorUuid)
			throws UnauthorizedErrorResponse, ApiResponseNotFoundError {
		final String methodLabel = "In getSensor(): ";
		logger.debug(methodLabel + "Hit");

		apiTokenService.validateApiToken(authHeader);

		return sensorService.get(sensorUuid);

	}

}
