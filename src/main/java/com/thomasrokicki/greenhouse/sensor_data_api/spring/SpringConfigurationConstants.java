package com.thomasrokicki.greenhouse.sensor_data_api.spring;


import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.thomasrokicki.greenhouse.sensor_data_api.utilities.EnvironmentEnum;

@Configuration
public class SpringConfigurationConstants {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    static {
    	logger.info("In " + MethodHandles.lookup().lookupClass().getSimpleName() + ": static init block.");
    }
	
	@Value("${spring.profiles.active:}")
	private String springProfilesActive;
	public String getSpringProfilesActive() {
		return springProfilesActive;
	}
	public void setSpringProfilesActive(String springProfilesActive) {
		this.springProfilesActive = springProfilesActive;
	}
	
	
	@Value("${app.version}")
	private String appVersion;
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
	
	@Value("${app.name}")
	private String appName;
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	
	@Value("${server.port}")
	private String serverPort;
    public String getServerPort() {
		return serverPort;
	}
    public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	
	
	@Value("${thisEnvironment:}")
	public void setThisEnvironment(String thisEnvironment) {
		this.thisEnvironment = thisEnvironment;
		this.setThisEnvironmentEnum(EnvironmentEnum.findByName(thisEnvironment));
	}
	private EnvironmentEnum thisEnvironmentEnum;
	public EnvironmentEnum getThisEnvironmentEnum() {
		return thisEnvironmentEnum;
	}
	public void setThisEnvironmentEnum(EnvironmentEnum thisEnvironmentEnum) {
		this.thisEnvironmentEnum = thisEnvironmentEnum;
	}
	private String thisEnvironment;
	public String getThisEnvironment() {
		return thisEnvironment;
	}
	
}
