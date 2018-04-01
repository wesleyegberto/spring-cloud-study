FROM openjdk:8-jre-alpine

COPY ./target/stock-service.jar stock-service.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./stock-service.jar"]

EXPOSE 8080