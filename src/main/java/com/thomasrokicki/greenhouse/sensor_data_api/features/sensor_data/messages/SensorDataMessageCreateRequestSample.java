package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages;

public class SensorDataMessageCreateRequestSample {

	private String sampledAt;
	private String sampleValue;

	public String getSampledAt() {
		return sampledAt;
	}

	public void setSampledAt(String sampledAt) {
		this.sampledAt = sampledAt;
	}

	public String getSampleValue() {
		return sampleValue;
	}

	public void setSampleValue(String sampleValue) {
		this.sampleValue = sampleValue;
	}

}
