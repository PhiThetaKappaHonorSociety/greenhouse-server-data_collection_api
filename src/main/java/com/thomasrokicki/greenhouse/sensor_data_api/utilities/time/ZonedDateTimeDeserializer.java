package com.thomasrokicki.greenhouse.sensor_data_api.utilities.time;

import java.io.IOException;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

	@Override
	public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {

		ZonedDateTimeConverter converter = new ZonedDateTimeConverter();
		return converter.convert(jsonParser.getText());

	}

}