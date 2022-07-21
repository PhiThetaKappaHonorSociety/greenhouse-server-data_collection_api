package com.thomasrokicki.greenhouse.sensor_data_api.features.api_token;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = ApiTokenMeta.thisPackage)
@EntityScan(basePackages = ApiTokenMeta.thisPackage)
public class ApiTokenSpringConfiguration {

	@Bean
	public ApiTokenService apiTokenService() {
		ApiTokenService apiTokenService = new ApiTokenService();
		return apiTokenService;
	}

}
