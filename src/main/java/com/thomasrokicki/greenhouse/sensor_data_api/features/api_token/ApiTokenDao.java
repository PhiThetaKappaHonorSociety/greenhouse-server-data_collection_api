package com.thomasrokicki.greenhouse.sensor_data_api.features.api_token;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "api_token")
public class ApiTokenDao {

	private Long apiTokenId;
	private String apiTokenUUID;
	private ZonedDateTime createdAtTsz;
	private ZonedDateTime lastUpdatedAtTsz;
	private String apiToken;
	private Boolean isActive;

	@Id
	@Column(name = "api_token_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getApiTokenId() {
		return apiTokenId;
	}
	public void setApiTokenId(Long apiTokenId) {
		this.apiTokenId = apiTokenId;
	}
	@Column(name = "api_token_uuid")
	public String getApiTokenUUID() {
		return apiTokenUUID;
	}
	public void setApiTokenUUID(String apiTokenUUID) {
		this.apiTokenUUID = apiTokenUUID;
	}
	@Column(name = "created_tsz")
	public ZonedDateTime getCreatedAtTsz() {
		return createdAtTsz;
	}
	public void setCreatedAtTsz(ZonedDateTime createdAtTsz) {
		this.createdAtTsz = createdAtTsz;
	}
	@Column(name = "last_updated_tsz")
	public ZonedDateTime getLastUpdatedAtTsz() {
		return lastUpdatedAtTsz;
	}
	public void setLastUpdatedAtTsz(ZonedDateTime lastUpdatedAtTsz) {
		this.lastUpdatedAtTsz = lastUpdatedAtTsz;
	}
	@Column(name = "api_token")
	public String getApiToken() {
		return apiToken;
	}
	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}
	@Column(name = "is_active")
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
