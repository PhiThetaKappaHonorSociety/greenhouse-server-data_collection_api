package com.thomasrokicki.greenhouse.sensor_data_api.features.sensor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<SensorDao, Long> {

	public Optional<SensorDao> findOneBySensorUuid(String uuid);

}
