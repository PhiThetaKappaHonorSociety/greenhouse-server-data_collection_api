package com.thomasrokicki.greenhouse.sensor_data_api.utilities.time;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeHelper {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static final ZoneId zoneId_UTC = ZoneId.of(ZoneOffset.UTC.getId());
	public static final ZoneId zoneId_Et = ZoneId.of("America/New_York");

	// **************
	// ** CREATORS **
	// **************
	public static ZonedDateTime nowUtc() {
		ZonedDateTime now = ZonedDateTime.now(zoneId_UTC);
		ZonedDateTime nowWithThreeNano = ZonedDateTime
				.parse(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")));
		return nowWithThreeNano;
	}

	// ****************
	// ** CONVERTERS **
	// ****************

	public static String convertToString(ZonedDateTime zonedDateTimeToConvert, TimePatternEnum timePattern) {
		if (zonedDateTimeToConvert == null) {
			return null;
		}
		try {
			return convertToString(zonedDateTimeToConvert, timePattern.getDateTimeFormatter());
		}
		catch (Exception e) {
			logger.error("Failed to convert zoned date time to string with timePattern: " + timePattern.getFormat());
			return null;
		}
	}

	public static String convertToString(ZonedDateTime zonedDateTimeToConvert, String dateTimeFormatterPattern) {
		if (zonedDateTimeToConvert == null || dateTimeFormatterPattern == null) {
			return null;
		}
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatterPattern);
			return convertToString(zonedDateTimeToConvert, formatter);
		}
		catch (Exception e) {
			logger.error("Failed to convert zoned date time to string with format: " + dateTimeFormatterPattern);
			return null;
		}
	}

	public static String convertToString(ZonedDateTime zonedDateTimeToConvert, DateTimeFormatter formatter) {
		if (zonedDateTimeToConvert == null || formatter == null) {
			return null;
		}
		try {
			String zonedDateTimeString = zonedDateTimeToConvert.format(formatter);
			return zonedDateTimeString;
		}
		catch (Exception e) {
			logger.error("Failed to convert zoned date time to string using formatter");
			return null;
		}
	}

	// *************
	// ** PARSERS **
	// *************

	public static ZonedDateTime parse(String stringToConvert, TimePatternEnum pattern) {
		if (stringToConvert == null || stringToConvert.isBlank() || pattern == null) {
			return null;
		}
		try {
			stringToConvert = stringToConvert.trim();
			ZonedDateTime convertedValue = null;

			switch (pattern) {
				case ISO8601_STANDARD:
					convertedValue = ZonedDateTime.parse(stringToConvert);
					break;
				case ISO_LOCAL_DATE:
					LocalDate localDate = LocalDate.parse(stringToConvert.substring(0, 10),
							DateTimeFormatter.ISO_LOCAL_DATE);

					convertedValue = localDate.atStartOfDay(ZoneOffset.UTC);
					break;
				default:
					logger.error("THIS TIME FORMAT IS NOT CURRENTLY SUPPORTED FOR PARSING. PLEASE ADD IT");
					stringToConvert = stringToConvert.trim();
					ZonedDateTime zdtResult = ZonedDateTime.parse(stringToConvert, pattern.getDateTimeFormatter());
					return zdtResult;
			}

			return convertedValue;

		}
		catch (Exception e) {
			logger.error("Failed to parse String into ZonedDateTime using format: " + pattern.getFormat());
			return null;
		}
	}

}
