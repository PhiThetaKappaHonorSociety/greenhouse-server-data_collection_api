package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data;

import java.lang.invoke.MethodHandles;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.SensorDao;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.SensorService;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages.SensorDataMessageCreateRequest;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages.SensorDataMessageCreateRequestSample;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages.SensorDataMessageCreateResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages.SensorDataMessageGetResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.ApiResponseNotFoundError;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.exceptions.BadRequestErrorResponse;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.time.TimeHelper;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.time.TimePatternEnum;

public class SensorDataService {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private SensorService sensorService;

	@Autowired
	private SensorDataRepository sensorDataRepository;

	public SensorDataMessageCreateResponse create(SensorDataMessageCreateRequest sensorDataMessageCreateRequest)
			throws BadRequestErrorResponse, ApiResponseNotFoundError {

		// Validate Request
		if (sensorDataMessageCreateRequest.getSensorUUID() == null
				|| sensorDataMessageCreateRequest.getSensorUUID().isBlank()) {
			throw new BadRequestErrorResponse("Field 'sensorUUID' must not be blank");
		}
		if (sensorDataMessageCreateRequest.getSamples() == null
				|| sensorDataMessageCreateRequest.getSamples().isEmpty()) {
			throw new BadRequestErrorResponse("List 'samples' must not be empty");
		}

		// Find sensor
		SensorDao foundSensorDao = sensorService.find(sensorDataMessageCreateRequest.getSensorUUID());
		if (foundSensorDao == null) {
			throw new ApiResponseNotFoundError(
					"Sensor not found for UUID: " + sensorDataMessageCreateRequest.getSensorUUID());
		}

		// Get samples
		List<SensorDataMessageCreateRequestSample> samples = sensorDataMessageCreateRequest.getSamples();

		// Process (async)
		processAndAdd(foundSensorDao, samples, TimeHelper.nowUtc());

		// Map Response
		SensorDataMessageCreateResponse response = new SensorDataMessageCreateResponse();
		response.setSensorUUID(foundSensorDao.getSensorUuid());
		response.setSamplesToBeProcessedCount(samples.size());

		// Return
		return response;

	}

	@Async
	private void processAndAdd(SensorDao sensorDao, List<SensorDataMessageCreateRequestSample> samples,
			ZonedDateTime ingestedTime) {
		final String methodLabel = "In processAndAdd(): ";
		for (SensorDataMessageCreateRequestSample sample : samples) {
			try {
				ZonedDateTime measuredAt = TimeHelper.parse(sample.getSampledAt(), TimePatternEnum.ISO8601_STANDARD);

				// Map Request
				SensorDataDao sensorDataDao = new SensorDataDao();
				sensorDataDao.setSensorDataId(null); // generated on save
				sensorDataDao.setSensorDataUuid(UUID.randomUUID().toString());
				sensorDataDao.setMeasuredAtTsz(measuredAt);
				sensorDataDao.setIngestedAtTsz(ingestedTime);
				sensorDataDao.setCreatedAtTsz(TimeHelper.nowUtc());
				sensorDataDao.setSensor(sensorDao);
				sensorDataDao.setSampleValue(sample.getSampleValue());

				SensorDataDao savedDao = add(sensorDataDao);

				// Check if saved
				if (savedDao == null) {
					logger.error("Failed to add sensor data. Add returned null");
				}

			} catch (Exception e) {
				logger.error(methodLabel + "Could not process sample: " + sample.getSampleValue() + " for sensor "
						+ sensorDao.getSensorUuid(), e);
			}
		}

	}

	public SensorDataDao add(SensorDataDao sensorDataDao) {
		final String methodLabel = "In add(): ";
		try {
			// Save
			SensorDataDao savedDao = sensorDataRepository.save(sensorDataDao);

			// Return
			return savedDao;

		} catch (Exception e) {
			logger.error(methodLabel + "Error adding sensor data", e);
			return null;
		}

	}

	public SensorDataDao find(String uuid) {
		final String methodLabel = "In find(): ";

		// Find
		Optional<SensorDataDao> foundDaoOptional = sensorDataRepository.findOneBySensorDataUuid(uuid);

		if (foundDaoOptional.isPresent()) {
			return foundDaoOptional.get();
		}

		logger.debug(methodLabel + "Sensor Data not found for UUID: " + uuid);
		return null;
	}

	public SensorDataMessageGetResponse get(String uuid) throws ApiResponseNotFoundError {
		final String methodLabel = "In get(): ";

		// Find Sensor Data
		SensorDataDao foundDao = find(uuid);
		if (foundDao == null) {
			throw new ApiResponseNotFoundError("Sensor Data not found for UUID: " + uuid);
		}

		// Map Response
		SensorDataMessageGetResponse response = new SensorDataMessageGetResponse();
		response.setSensorDataUUID(foundDao.getSensorDataUuid());
		response.setCreatedAtTsz(foundDao.getCreatedAtTsz());
		response.setIngestedAtTsz(foundDao.getIngestedAtTsz());
		response.setMeasuredAtTsz(foundDao.getMeasuredAtTsz());
		response.setSensorUUID(foundDao.getSensor().getSensorUuid());
		response.setSampleValue(foundDao.getSampleValue());

		// Return
		return response;
	}

	public List<SensorDataMessageGetResponse> getMany(String sensorUUID) {
		final String methodLabel = "In getMany(): ";

		// TODO Add paging, query params, and averaging
		logger.error(methodLabel + "Business logic is not implemented");

		return null;

	}

	public SensorDataMessageGetResponse getMostRecentDataBySensorUuid(String sensorUUID)
			throws ApiResponseNotFoundError {
		final String methodLabel = "In getMostRecentDataBySensorUuid(): ";

		// Get Latest value
		Optional<SensorDataDao> foundDaoOptional = sensorDataRepository
				.findFirstBySensorSensorUuidOrderByMeasuredAtTszDesc(sensorUUID);
		if (foundDaoOptional.isEmpty()) {
			throw new ApiResponseNotFoundError("Sensor Data not found for SensorUUID: " + sensorUUID);
		}

		SensorDataDao foundDao = foundDaoOptional.get();

		SensorDataMessageGetResponse response = new SensorDataMessageGetResponse();
		response.setSensorDataUUID(foundDao.getSensorDataUuid());
		response.setCreatedAtTsz(foundDao.getCreatedAtTsz());
		response.setIngestedAtTsz(foundDao.getIngestedAtTsz());
		response.setMeasuredAtTsz(foundDao.getMeasuredAtTsz());
		response.setSensorUUID(foundDao.getSensor().getSensorUuid());
		response.setSampleValue(foundDao.getSampleValue());

		return response;
	}
}
