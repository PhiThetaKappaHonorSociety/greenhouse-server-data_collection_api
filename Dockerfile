# From spring boot docs (https://spring.io/guides/gs/spring-boot-docker/)

# FROM --platform=linux/amd64 openjdk:11-jdk
FROM --platform=linux/amd64 gcr.io/distroless/java:11

VOLUME /tmp
VOLUME /target

ARG WAR_FILE
COPY ${WAR_FILE} app.war

EXPOSE ${APP_PORT}
EXPOSE 8080

# New Relic APM
# RUN ["apt-get", "install", "unzip"]

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]
