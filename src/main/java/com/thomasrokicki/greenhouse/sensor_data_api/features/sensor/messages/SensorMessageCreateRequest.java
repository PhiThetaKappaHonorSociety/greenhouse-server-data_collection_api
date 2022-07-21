package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.messages;

public class SensorMessageCreateRequest {

	private String sensorFriendlyName;
	private String sensorType;

	public String getSensorFriendlyName() {
		return sensorFriendlyName;
	}

	public void setSensorFriendlyName(String sensorFriendlyName) {
		this.sensorFriendlyName = sensorFriendlyName;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

}
