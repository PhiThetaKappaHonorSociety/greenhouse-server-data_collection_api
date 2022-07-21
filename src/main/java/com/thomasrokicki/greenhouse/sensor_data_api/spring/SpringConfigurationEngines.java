package com.thomasrokicki.greenhouse.sensor_data_api.spring;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

public class SpringConfigurationEngines {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    static {
    	logger.info("In " + MethodHandles.lookup().lookupClass().getSimpleName() + ": static init block.");
    }
    
//    @Bean
//    public DataSourceEngine dataSourceEngine() {
//    	DataSourceEngine dataSourceEngine = new DataSourceEngine();
//    	return dataSourceEngine;
//    }
}
