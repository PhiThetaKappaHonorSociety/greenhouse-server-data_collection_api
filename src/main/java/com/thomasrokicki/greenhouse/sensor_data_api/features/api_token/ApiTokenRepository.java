package com.thomasrokicki.greenhouse.sensor_data_api.features.api_token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiTokenRepository extends JpaRepository<ApiTokenDao, Long> {

	public ApiTokenDao findByApiToken(String apiToken);
}
