package com.thomasrokicki.greenhouse.sensor_data_api.main;

import java.lang.invoke.MethodHandles;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import com.thomasrokicki.greenhouse.sensor_data_api.spring.SpringConfigurationApplication;
import com.thomasrokicki.greenhouse.sensor_data_api.spring.SpringConfigurationConstants;

@Configuration
@EnableAsync
@EnableAutoConfiguration
//@EnableScheduling
@Import({
	SpringConfigurationApplication.class
})
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    static {
    	logger.info("In " + MethodHandles.lookup().lookupClass().getSimpleName() + ": static init block.");
    }
    
    @Autowired
    private SpringConfigurationConstants springConfigurationConstants;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
		// http://patorjk.com/software/taag
		logger.info("===============================================");
		logger.info("   ╔═╗┬ ┬┬  ╔╦╗┬ ┬┌─┐┌┬┐┌─┐  ╦╔═┌─┐┌─┐┌─┐┌─┐   ");
		logger.info("   ╠═╝├─┤│   ║ ├─┤├┤  │ ├─┤  ╠╩╗├─┤├─┘├─┘├─┤   ");
		logger.info("   ╩  ┴ ┴┴   ╩ ┴ ┴└─┘ ┴ ┴ ┴  ╩ ╩┴ ┴┴  ┴  ┴ ┴   ");
		logger.info("===============================================");
		logger.info("                 CONTRIBUTORS                  ");
		logger.info("                 ++++++++++++                  ");
		logger.info(" - THOMAS ROKICKI | Class of '19               ");
		logger.info("===============================================");
		logger.info("Server Started. Running on port: " + springConfigurationConstants.getServerPort());
		logger.info("===============================================");
	
	}
}
