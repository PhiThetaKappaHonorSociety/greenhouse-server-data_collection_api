-- ------------------------------------------------------------------------------------------------
-- api_token table
-- ------------------------------------------------------------------------------------------------
CREATE TABLE api_token (
    api_token_id             BIGSERIAL PRIMARY KEY,
    api_token_uuid           TEXT NOT NULL UNIQUE,
    created_tsz              TIMESTAMP WITH TIME ZONE,
    last_updated_tsz         TIMESTAMP WITH TIME ZONE,
    api_token                TEXT,
    is_active                BOOLEAN NOT NULL
);

-- ------------------------------------------------------------------------------------------------
-- sensor table
-- ------------------------------------------------------------------------------------------------
CREATE TABLE sensor (
    sensor_id             	BIGSERIAL PRIMARY KEY,
    sensor_uuid           	TEXT NOT NULL UNIQUE,
    created_tsz             TIMESTAMP WITH TIME ZONE,
    last_updated_tsz        TIMESTAMP WITH TIME ZONE,
    friendly_name           TEXT,
    sensor_type 			TEXT
);


-- ------------------------------------------------------------------------------------------------
-- sensor_data table
-- ------------------------------------------------------------------------------------------------
CREATE TABLE sensor_data (
    sensor_data_id             	BIGSERIAL PRIMARY KEY,
    sensor_data_uuid           	TEXT NOT NULL UNIQUE,
    created_tsz             	TIMESTAMP WITH TIME ZONE,
    ingested_tsz        		TIMESTAMP WITH TIME ZONE,
    measured_tsz        		TIMESTAMP WITH TIME ZONE,
    sensor_id           		BIGINT REFERENCES sensor,
    sample_value 				TEXT
);