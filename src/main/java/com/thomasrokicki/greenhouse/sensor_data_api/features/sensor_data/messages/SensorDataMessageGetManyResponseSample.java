package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.messages;

import java.time.ZonedDateTime;

public class SensorDataMessageGetManyResponseSample {

	private ZonedDateTime createdAtTsz;
	private ZonedDateTime measuredAtTsz;
	private ZonedDateTime ingestedAtTsz;
	private String sampleValue;

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

	public String getSampleValue() {
		return sampleValue;
	}

	public void setSampleValue(String sampleValue) {
		this.sampleValue = sampleValue;
	}

}
