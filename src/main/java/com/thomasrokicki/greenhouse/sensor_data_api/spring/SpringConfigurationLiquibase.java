package com.thomasrokicki.greenhouse.sensor_data_api.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;

/**
 * Helpful links:
 *   Preconditions
 *   https://docs.liquibase.com/concepts/advanced/preconditions.html
 *   xml -> json
 *   https://stackoverflow.com/questions/23921460/liquibase-preconditions-yaml
 */
@Configuration
public class SpringConfigurationLiquibase {

//	@Qualifier("primaryDataSource")
	@Autowired
	private DataSource dataSource;

	@Bean
	public SpringLiquibase liquibase() {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:database/changelog/db_changelog_master.json");
		liquibase.setDataSource(dataSource);
		return liquibase;
	}
}
