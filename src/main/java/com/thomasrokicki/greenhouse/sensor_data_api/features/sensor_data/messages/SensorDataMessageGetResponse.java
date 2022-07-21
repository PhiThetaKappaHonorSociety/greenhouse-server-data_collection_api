package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages;

import java.time.ZonedDateTime;

import com.thomasrokicki.greenhouse.sensor_data_api.utilities.controller_models.ApiResponse;

public class SensorDataMessageGetResponse implements ApiResponse {

	private String sensorDataUUID;
	private ZonedDateTime createdAtTsz;
	private ZonedDateTime measuredAtTsz;
	private ZonedDateTime ingestedAtTsz;
	private String sensorUUID;
	private String sampleValue;

	public String getSensorDataUUID() {
		return sensorDataUUID;
	}

	public void setSensorDataUUID(String sensorDataUUID) {
		this.sensorDataUUID = sensorDataUUID;
	}

	public ZonedDateTime getCreatedAtTsz() {
		return createdAtTsz;
	}

	public void setCreatedAtTsz(ZonedDateTime createdAtTsz) {
		this.createdAtTsz = createdAtTsz;
	}

	public ZonedDateTime getMeasuredAtTsz() {
		return measuredAtTsz;
	}

	public void setMeasuredAtTsz(ZonedDateTime measuredAtTsz) {
		this.measuredAtTsz = measuredAtTsz;
	}

	public ZonedDateTime getIngestedAtTsz() {
		return ingestedAtTsz;
	}

	public void setIngestedAtTsz(ZonedDateTime ingestedAtTsz) {
		this.ingestedAtTsz = ingestedAtTsz;
	}

	public String getSensorUUID() {
		return sensorUUID;
	}

	public void setSensorUUID(String sensorUUID) {
		this.sensorUUID = sensorUUID;
	}

	public String getSampleValue() {
		return sampleValue;
	}

	public void setSampleValue(String sampleValue) {
		this.sampleValue = sampleValue;
	}

}
