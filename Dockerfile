#FROM ubuntu:latest
#LABEL authors="vasu"
#
#ENTRYPOINT ["top", "-b"]
FROM openjdk:21

WORKDIR /app

COPY build/libs/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]