package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.SensorDao;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "sensor_data")
public class SensorDataDao {

	private Long sensorDataId;
	private String sensorDataUuid;
	private SensorDao sensor;
	private ZonedDateTime createdAtTsz;
	private ZonedDateTime measuredAtTsz;
	private ZonedDateTime ingestedAtTsz;
	private String sampleValue;

	@Id
	@Column(name = "sensor_data_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getSensorDataId() {
		return sensorDataId;
	}

	public void setSensorDataId(Long sensorDataId) {
		this.sensorDataId = sensorDataId;
	}

	@Column(name = "sensor_data_uuid")
	public String getSensorDataUuid() {
		return sensorDataUuid;
	}

	public void setSensorDataUuid(String sensorDataUUID) {
		this.sensorDataUuid = sensorDataUUID;
	}

	@ManyToOne
	@JoinColumn(name = "sensor_id")
	public SensorDao getSensor() {
		return sensor;
	}

	public void setSensor(SensorDao sensor) {
		this.sensor = sensor;
	}

	@Column(name = "created_tsz")
	public ZonedDateTime getCreatedAtTsz() {
		return createdAtTsz;
	}

	public void setCreatedAtTsz(ZonedDateTime createdAtTsz) {
		this.createdAtTsz = createdAtTsz;
	}

	@Column(name = "measured_tsz")
	public ZonedDateTime getMeasuredAtTsz() {
		return measuredAtTsz;
	}

	public void setMeasuredAtTsz(ZonedDateTime measuredAtTsz) {
		this.measuredAtTsz = measuredAtTsz;
	}

	@Column(name = "ingested_tsz")
	public ZonedDateTime getIngestedAtTsz() {
		return ingestedAtTsz;
	}

	public void setIngestedAtTsz(ZonedDateTime ingestedAtTsz) {
		this.ingestedAtTsz = ingestedAtTsz;
	}

	@Column(name = "sample_value")
	public String getSampleValue() {
		return sampleValue;
	}

	public void setSampleValue(String sampleValue) {
		this.sampleValue = sampleValue;
	}

}
