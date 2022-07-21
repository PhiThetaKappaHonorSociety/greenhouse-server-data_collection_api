package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.enums;

import javax.persistence.AttributeConverter;

public class SensorTypeEnumAttributeConverter  implements AttributeConverter<SensorTypeEnum, String> {

	@Override
	public SensorTypeEnum convertToEntityAttribute(String typeString) {
		return SensorTypeEnum.forType(typeString);
	}

	@Override
	public String convertToDatabaseColumn(SensorTypeEnum dbData) {
		if (dbData != null)
			return dbData.getType();
		return null;
	}

}