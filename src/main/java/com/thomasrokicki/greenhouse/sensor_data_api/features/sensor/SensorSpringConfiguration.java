package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = SensorMeta.thisPackage)
@EntityScan(basePackages = SensorMeta.thisPackage)
public class SensorSpringConfiguration {

	@Bean
	public SensorService sensorService() {
		SensorService sensorService = new SensorService();
		return sensorService;
	}

	@Bean
	public SensorController sensorController() {
		SensorController sensorController = new SensorController();
		return sensorController;
	}
}
