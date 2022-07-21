package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor_data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorDataDao, Long> {

	Optional<SensorDataDao> findOneBySensorDataUuid(String uuid);
	
	Optional<SensorDataDao> findFirstBySensorSensorUuidOrderByMeasuredAtTszDesc(String sensorUUID);
	

}
