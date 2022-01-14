FROM openjdk:17-alpine

WORKDIR /app

COPY target/*.jar application.jar

ENTRYPOINT ["java", "-jar", "./application.jar"]
