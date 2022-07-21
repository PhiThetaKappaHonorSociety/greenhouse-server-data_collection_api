package com.thomasrokicki.greenhouse.sensor_data_api.utilities.time;

import java.lang.invoke.MethodHandles;
import java.time.ZonedDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class ZonedDateTimeConverter implements Converter<String, ZonedDateTime> {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private List<TimePatternEnum> patternsToTry = List.of(
			TimePatternEnum.ISO8601_STANDARD,
			TimePatternEnum.ISO_LOCAL_DATE
			);

	public List<TimePatternEnum> getPatternsToTry() {
		return patternsToTry;
	}

	public void setPatternsToTry(List<TimePatternEnum> patternsToTry) {
		this.patternsToTry = patternsToTry;
	}

	@Override
	public ZonedDateTime convert(String source) {
		ZonedDateTime zonedDateTime = null;
		for (TimePatternEnum dateTimePattern : patternsToTry) {
			zonedDateTime = TimeHelper.parse(source, dateTimePattern);
			if (zonedDateTime != null) {
				logger.debug("Successfully converted String into ZonedDateTime: " + zonedDateTime.toString());
				break;
			}
		}
		return zonedDateTime;
	}
}
