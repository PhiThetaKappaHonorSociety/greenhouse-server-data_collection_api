package com.thomasrokicki.greenhouse.sensor_data_api.spring;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Import;

@Import({
	SpringConfigurationConstants.class,
	SpringConfigurationEngines.class,
	SpringConfigurationFeatures.class,
	SpringConfigurationLiquibase.class,
	SpringConfigurationObjectMapper.class,
	SpringConfigurationTaskExecutors.class,
	SpringConfigurationWebMvcCors.class
})
public class SpringConfigurationApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    static {
    	logger.info("In " + MethodHandles.lookup().lookupClass().getSimpleName() + ": static init block.");
    }
	
}
