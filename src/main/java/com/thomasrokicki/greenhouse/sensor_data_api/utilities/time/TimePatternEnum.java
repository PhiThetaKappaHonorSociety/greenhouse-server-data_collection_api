package com.thomasrokicki.greenhouse.sensor_data_api.utilities.time;

import java.time.format.DateTimeFormatter;
import java.util.EnumSet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TimePatternEnum {

	/**
	 * yyyy-MM-dd'T'HH:mm:ss.SSSX
	 */
	ISO8601_STANDARD("yyyy-MM-dd'T'HH:mm:ss.SSSX"),
	/**
	 * yyyy-MM-dd
	 */
	ISO_LOCAL_DATE("yyyy-MM-dd");

	private String format;
	private static final EnumSet<TimePatternEnum> allThese = EnumSet.allOf(TimePatternEnum.class);

	TimePatternEnum(String format) {
		this.format = format;
	}

	@JsonValue
	public String getFormat() {
		return format;
	}

	@JsonCreator
	public static TimePatternEnum forValue(String format) {
		for (TimePatternEnum e : allThese) {
			if (e.getFormat().equals(format))
				return e;
		}
		return null;
	}

	public DateTimeFormatter getDateTimeFormatter() {
		return DateTimeFormatter.ofPattern(format);
	}
}
