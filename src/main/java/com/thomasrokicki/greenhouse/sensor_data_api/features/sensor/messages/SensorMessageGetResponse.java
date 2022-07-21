package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.messages;

import java.time.ZonedDateTime;

public class SensorMessageGetResponse {

	private String sensorUUID;
	private ZonedDateTime createdAtTsz;
	private ZonedDateTime lastModifiedAtTsz;
	private String sensorFriendlyName;
	private String sensorTypeName;
	private String sensorTypeUnit;

	public String getSensorUUID() {
		return sensorUUID;
	}

	public void setSensorUUID(String sensorUUID) {
		this.sensorUUID = sensorUUID;
	}

	public ZonedDateTime getCreatedAtTsz() {
		return createdAtTsz;
	}

	public void setCreatedAtTsz(ZonedDateTime createdAtTsz) {
		this.createdAtTsz = createdAtTsz;
	}

	public ZonedDateTime getLastModifiedAtTsz() {
		return lastModifiedAtTsz;
	}

	public void setLastModifiedAtTsz(ZonedDateTime lastModifiedAtTsz) {
		this.lastModifiedAtTsz = lastModifiedAtTsz;
	}

	public String getSensorFriendlyName() {
		return sensorFriendlyName;
	}

	public void setSensorFriendlyName(String sensorFriendlyName) {
		this.sensorFriendlyName = sensorFriendlyName;
	}

	public String getSensorTypeName() {
		return sensorTypeName;
	}

	public void setSensorTypeName(String sensorTypeName) {
		this.sensorTypeName = sensorTypeName;
	}

	public String getSensorTypeUnit() {
		return sensorTypeUnit;
	}

	public void setSensorTypeUnit(String sensorTypeUnit) {
		this.sensorTypeUnit = sensorTypeUnit;
	}

}
