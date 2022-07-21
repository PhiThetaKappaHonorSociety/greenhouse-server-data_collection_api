-- Create API Token (EXAMPLE DONT RUN THIS)
INSERT INTO api_token (api_token_uuid, created_tsz, last_updated_tsz, api_token, is_active) 
values (
	'b55accab-d67c-4f53-b6b5-307747ca3fc0', 
	'2022-07-10T20:06'::timestamptz, 
	'2022-07-10T20:06'::timestamptz, 
	'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 
	true
);