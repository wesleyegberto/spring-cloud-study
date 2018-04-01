FROM openjdk:8-jre-alpine

COPY ./target/store-service.jar store-service.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./store-service.jar"]

EXPOSE 8080
