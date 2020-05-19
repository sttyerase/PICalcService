FROM openjdk:8-jdk-alpine AS builder
WORKDIR target/
ARG APPJAR=target/PICalcService-0.0.1-SNAPSHOT.jar
COPY ${APPJAR} app.jar

ENTRYPOINT ["java","-jar","app.jar"]
