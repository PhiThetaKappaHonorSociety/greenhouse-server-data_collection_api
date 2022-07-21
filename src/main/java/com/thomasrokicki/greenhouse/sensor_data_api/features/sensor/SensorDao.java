package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.enums.SensorTypeEnum;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.enums.SensorTypeEnumAttributeConverter;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "sensor")
public class SensorDao {

	private Long sensorId;
	private String sensorUuid;
	private ZonedDateTime createdAtTsz;
	private ZonedDateTime lastModifiedAtTsz;
	private String sensorFriendlyName;
	private SensorTypeEnum sensorTypeEnum;

	@Id
	@Column(name = "sensor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getSensorId() {
		return sensorId;
	}

	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}

	@Column(name = "sensor_uuid")
	public String getSensorUuid() {
		return sensorUuid;
	}

	public void setSensorUuid(String sensorUUID) {
		this.sensorUuid = sensorUUID;
	}

	@Column(name = "created_tsz")
	public ZonedDateTime getCreatedAtTsz() {
		return createdAtTsz;
	}

	public void setCreatedAtTsz(ZonedDateTime createdAtTsz) {
		this.createdAtTsz = createdAtTsz;
	}

	@Column(name = "last_updated_tsz")
	public ZonedDateTime getLastModifiedAtTsz() {
		return lastModifiedAtTsz;
	}

	public void setLastModifiedAtTsz(ZonedDateTime lastModifiedAtTsz) {
		this.lastModifiedAtTsz = lastModifiedAtTsz;
	}

	@Column(name = "friendly_name")
	public String getSensorFriendlyName() {
		return sensorFriendlyName;
	}

	public void setSensorFriendlyName(String sensorFriendlyName) {
		this.sensorFriendlyName = sensorFriendlyName;
	}

	@Column(name = "sensor_type")
	@Convert(converter = SensorTypeEnumAttributeConverter.class)
	public SensorTypeEnum getSensorTypeEnum() {
		return sensorTypeEnum;
	}

	public void setSensorTypeEnum(SensorTypeEnum sensorTypeEnum) {
		this.sensorTypeEnum = sensorTypeEnum;
	}

}
