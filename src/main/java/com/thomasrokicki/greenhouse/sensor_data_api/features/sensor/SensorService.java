package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.enums.SensorTypeEnum;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.messages.SensorMessageCreateRequest;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.messages.SensorMessageCreateResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.ApiResponseNotFoundError;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.BadRequestErrorResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.InternalServerErrorResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.time.TimeHelper;

public class SensorService {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private SensorRepository sensorRepository;

	public SensorMessageCreateResponse add(SensorMessageCreateRequest sensorCreateRequest)
			throws InternalServerErrorResponse, BadRequestErrorResponse {
		final String methodLabel = "In add(): ";

		validateCreateRequestBody(sensorCreateRequest);
		try {

			// Map Request
			SensorDao sensorDao = new SensorDao();
			sensorDao.setSensorId(null); // generated on save
			sensorDao.setSensorUuid(UUID.randomUUID().toString());
			sensorDao.setCreatedAtTsz(TimeHelper.nowUtc());
			sensorDao.setLastModifiedAtTsz(TimeHelper.nowUtc());
			sensorDao.setSensorFriendlyName(sensorCreateRequest.getSensorFriendlyName());
			sensorDao.setSensorTypeEnum(SensorTypeEnum.forType(sensorCreateRequest.getSensorType()));

			// Save
			SensorDao savedDao = sensorRepository.save(sensorDao);

			// Check if saved
			if (savedDao == null) {
				throw new InternalServerErrorResponse("Failed to save sensor");
			}

			// Map Response
			SensorMessageCreateResponse response = new SensorMessageCreateResponse();
			response.setSensorUUID(savedDao.getSensorUuid());
			response.setCreatedAtTsz(savedDao.getCreatedAtTsz());
			response.setLastModifiedAtTsz(savedDao.getLastModifiedAtTsz());
			response.setSensorFriendlyName(savedDao.getSensorFriendlyName());
			response.setSensorTypeName(savedDao.getSensorTypeEnum().getType());
			response.setSensorTypeUnit(savedDao.getSensorTypeEnum().getUnit());

			// Return
			return response;

		} catch (Exception e) {
			logger.error(methodLabel + "Failed to save", e);
			throw new InternalServerErrorResponse("Failed to save sensor", e);
		}
	}

	public SensorDao find(String uuid) {
		final String methodLabel = "In find(): ";

		// Find
		Optional<SensorDao> foundDaoOptional = sensorRepository.findOneBySensorUuid(uuid);

		if (foundDaoOptional.isPresent()) {
			return foundDaoOptional.get();
		}

		logger.debug(methodLabel + "Sensor not found for UUID: " + uuid);
		return null;
	}

	public SensorMessageCreateResponse get(String uuid) throws ApiResponseNotFoundError {
		// Find Sensor
		SensorDao foundDao = find(uuid);
		if (foundDao == null) {
			throw new ApiResponseNotFoundError("Sensor not found for UUID: " + uuid);
		}

		// Map Response
		SensorMessageCreateResponse response = new SensorMessageCreateResponse();
		response.setSensorUUID(foundDao.getSensorUuid());
		response.setCreatedAtTsz(foundDao.getCreatedAtTsz());
		response.setLastModifiedAtTsz(foundDao.getLastModifiedAtTsz());
		response.setSensorFriendlyName(foundDao.getSensorFriendlyName());
		response.setSensorTypeName(foundDao.getSensorTypeEnum().getType());
		response.setSensorTypeUnit(foundDao.getSensorTypeEnum().getUnit());

		// Return
		return response;

	}

	public List<SensorMessageCreateResponse> findMany() throws ApiResponseNotFoundError {
		final String methodLabel = "In findMany(): ";

		// TODO Implement paging

		// Find
		List<SensorDao> foundDaos = sensorRepository.findAll();

		// Map Daos
		List<SensorMessageCreateResponse> sensors = new ArrayList<>();
		for (SensorDao foundDao : foundDaos) {
			SensorMessageCreateResponse sensorCreateResponse = new SensorMessageCreateResponse();
			sensorCreateResponse.setSensorUUID(foundDao.getSensorUuid());
			sensorCreateResponse.setCreatedAtTsz(foundDao.getCreatedAtTsz());
			sensorCreateResponse.setLastModifiedAtTsz(foundDao.getLastModifiedAtTsz());
			sensorCreateResponse.setSensorFriendlyName(foundDao.getSensorFriendlyName());
			sensorCreateResponse.setSensorTypeName(foundDao.getSensorTypeEnum().getType());
			sensorCreateResponse.setSensorTypeUnit(foundDao.getSensorTypeEnum().getUnit());

			sensors.add(sensorCreateResponse);
		}

		if (sensors == null || sensors.isEmpty()) {
			logger.error(methodLabel + "No sensors mapped. Found daos: " + foundDaos);
			throw new ApiResponseNotFoundError("There are no sensors matching your search");
		}

		return sensors;
	}

	private void validateCreateRequestBody(SensorMessageCreateRequest sensorCreateRequest)
			throws BadRequestErrorResponse {
		if (sensorCreateRequest.getSensorFriendlyName() == null
				|| sensorCreateRequest.getSensorFriendlyName().isBlank()) {
			throw new BadRequestErrorResponse("Field 'sensorFriendlyName' must not be blank");
		}

		if (sensorCreateRequest.getSensorType() == null || sensorCreateRequest.getSensorType().isBlank()) {
			throw new BadRequestErrorResponse("Field 'sensorType' must not be blank");
		}

		if (SensorTypeEnum.forType(sensorCreateRequest.getSensorType()) == null) {
			throw new BadRequestErrorResponse(
					"Field 'sensorType' is invalid. Try 'fahrenheit', 'celsius', 'humidity', or 'other'");
		}

	}

}
