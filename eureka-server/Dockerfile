FROM openjdk:8-jre-alpine

COPY ./target/eureka-server.jar eureka-server.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./eureka-server.jar"]

EXPOSE 8761