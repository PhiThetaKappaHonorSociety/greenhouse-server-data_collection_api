package com.thomasrokicki.greenhouse.sensor_data_api.utilities;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Set params in SpringConfigurationConstants and application.properties
 * Then populate values into this enum in SpringConfigurationEnvironment
 */
public enum EnvironmentEnum {

	local(1, "local"), dev(2, "dev"), prod(3, "prod");

	public static EnumSet<EnvironmentEnum> allThese = EnumSet.allOf(EnvironmentEnum.class);
	private static List<EnvironmentEnum> allTheseList;

	private Integer environmentId;
	private String name;

	public Integer getEnvironmentId() {
		return environmentId;
	}

	public void setEnvironmentId(Integer environmentId) {
		this.environmentId = environmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static List<EnvironmentEnum> findAll() {
		if (allTheseList == null) {
			List<EnvironmentEnum> allTheseList = new ArrayList<>();
			for (EnvironmentEnum environment : allThese) {
				allTheseList.add(environment);
			}
		}
		return allTheseList;
	}

	public static EnvironmentEnum findByName(String name) {
		if (name == null) {
			return null;
		}
		for (EnvironmentEnum environment : allThese) {
			if (environment.name().equalsIgnoreCase(name)) {
				return environment;
			}
		}
		return null;
	}

	public static EnvironmentEnum findById(Integer id) {
		if (id == null) {
			return null;
		}
		for (EnvironmentEnum environment : allThese) {
			if (environment.getEnvironmentId() == id) {
				return environment;
			}
		}
		return null;
	}

	private EnvironmentEnum(Integer environmentId, String name) {
		this.environmentId = environmentId;
		this.name = name;
	}
}
