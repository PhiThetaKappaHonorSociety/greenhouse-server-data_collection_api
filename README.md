# greenhouse-server-data_collection_api
Spring App API for Sensor Data


# To Build

We build docker container images to run using docker-compose

To build the container
1. Build the jar file by running the "greenhouse - sensor_data_api - clean install" Eclipse Launch File
2. Open terminal inside the workspace root directory (it contains the Dockerfile)
3. Build docker image (You will need docker installed on your computer)

```
docker build --build-arg APP_PORT=8732 --build-arg WAR_FILE=target/sensor_data_api-1.0.0.war -t tcrokicki/ptk-greenhouse-server-sensor_data_api:v1.0.0 .

```


4. Push to Docker Hub when ready for release

```
docker push tcrokicki/ptk-greenhouse-server-sensor_data_api:v1.0.0
```



# Useful commands

### Sign in to docker hub
`docker login --username USERNAME`

### To run container
`docker run --env xxx='zzzz' greenhouse-server-data_collection_api:1.0.0`