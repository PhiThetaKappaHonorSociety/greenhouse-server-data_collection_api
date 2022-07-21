package com.thomasrokicki.greenhouse.sensor_data_api.spring;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Import;

import com.thomasrokicki.greenhouse.sensor_data_api.features.api_token.ApiTokenSpringConfiguration;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor.SensorSpringConfiguration;
import com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data.SensorDataSpringConfiguration;

@Import({ 
	ApiTokenSpringConfiguration.class, 
	SensorSpringConfiguration.class, 
	SensorDataSpringConfiguration.class 
	})
public class SpringConfigurationFeatures {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	static {
		logger.info("In " + MethodHandles.lookup().lookupClass().getSimpleName() + ": static init block.");
	}
}
