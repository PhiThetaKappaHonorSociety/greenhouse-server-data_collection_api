package com.thomasrokicki.greenhouse.sensor_data_api.spring;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SpringConfigurationWebMvcCors implements WebMvcConfigurer {

	/*
	 * CORS Mappings
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// Do not use in production
		registry.addMapping("/**")
				// For testing
				.allowedOrigins("*").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
	}
}
