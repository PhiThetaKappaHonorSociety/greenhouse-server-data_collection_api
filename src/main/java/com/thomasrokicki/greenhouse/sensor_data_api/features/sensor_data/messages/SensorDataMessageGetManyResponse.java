package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages;

import java.util.List;

import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.SensorDao;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.controller_models.ApiResponse;

public class SensorDataMessageGetManyResponse implements ApiResponse {

	private String sensorDataUUID;
	private SensorDao sensor;
	private List<SensorDataMessageGetManyResponseSample> samples;

	public String getSensorDataUUID() {
		return sensorDataUUID;
	}

	public void setSensorDataUUID(String sensorDataUUID) {
		this.sensorDataUUID = sensorDataUUID;
	}

	public SensorDao getSensor() {
		return sensor;
	}

	public void setSensor(SensorDao sensor) {
		this.sensor = sensor;
	}

	public List<SensorDataMessageGetManyResponseSample> getSamples() {
		return samples;
	}

	public void setSamples(List<SensorDataMessageGetManyResponseSample> samples) {
		this.samples = samples;
	}

}
