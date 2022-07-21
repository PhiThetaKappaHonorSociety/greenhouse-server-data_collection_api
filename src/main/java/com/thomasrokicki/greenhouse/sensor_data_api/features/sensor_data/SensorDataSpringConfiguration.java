package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = SensorDataMeta.thisPackage)
@EntityScan(basePackages = SensorDataMeta.thisPackage)
public class SensorDataSpringConfiguration {

	@Bean
	public SensorDataController sensorDataController() {
		SensorDataController sensorDataController = new SensorDataController();
		return sensorDataController;
	}

	@Bean
	public SensorDataService sensorDataService() {
		SensorDataService sensorDataService = new SensorDataService();
		return sensorDataService;
	}
}
