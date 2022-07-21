package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.enums;

import java.util.EnumSet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SensorTypeEnum {
	TEMP_F("fahrenheit", "°F"), TEMP_C("celsius", "°C"), HUMIDITY("humidity", "RH"), OTHER("other", "");

	private String type;
	private String unit;
	private static final EnumSet<SensorTypeEnum> allThese = EnumSet.allOf(SensorTypeEnum.class);

	SensorTypeEnum(String type, String unit) {
		this.type = type;
		this.unit = unit;
	}

	@JsonValue
	public String getType() {
		return type;
	}

	@JsonValue
	public String getUnit() {
		return unit;
	}

	@JsonCreator
	public static SensorTypeEnum forType(String typeValue) {
		for (SensorTypeEnum e : allThese) {
			if (e.getType().equalsIgnoreCase(typeValue))
				return e;
		}
		return null;
	}
}
