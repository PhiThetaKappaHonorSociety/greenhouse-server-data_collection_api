package com.thomasrokicki.greenhouse.sensor_data_api.spring;

import java.time.ZonedDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.thomasrokicki.greenhouse.sensor_data_api.utilities.time.ZonedDateTimeDeserializer;

public class SpringConfigurationObjectMapper {
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		SimpleModule module = new SimpleModule();
		module.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
		mapper.registerModule(module);
		
		return mapper;
	}
}
