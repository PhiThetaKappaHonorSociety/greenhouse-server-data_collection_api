package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages;

import com.thomasrokicki.greenhouse.sensor_data_api.utilities.controller_models.ApiResponse;

public class SensorDataMessageCreateResponse implements ApiResponse {

	private String sensorUUID;
	private Integer samplesToBeProcessedCount;

	public String getSensorUUID() {
		return sensorUUID;
	}

	public void setSensorUUID(String sensorUUID) {
		this.sensorUUID = sensorUUID;
	}

	public Integer getSamplesToBeProcessedCount() {
		return samplesToBeProcessedCount;
	}

	public void setSamplesToBeProcessedCount(Integer samplesToBeProcessedCount) {
		this.samplesToBeProcessedCount = samplesToBeProcessedCount;
	}

}
