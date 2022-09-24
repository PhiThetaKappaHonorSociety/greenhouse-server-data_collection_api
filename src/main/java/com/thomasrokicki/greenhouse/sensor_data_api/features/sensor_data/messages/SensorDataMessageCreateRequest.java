package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages;

import java.util.List;

public class SensorDataMessageCreateRequest {

	private String sensorUUID;
	private List<SensorDataMessageCreateRequestSample> samples;

	public String getSensorUUID() {
		return sensorUUID;
	}

	public void setSensorUUID(String sensorUUID) {
		this.sensorUUID = sensorUUID;
	}

	public List<SensorDataMessageCreateRequestSample> getSamples() {
		return samples;
	}

	public void setSamples(List<SensorDataMessageCreateRequestSample> samples) {
		this.samples = samples;
	}

}
