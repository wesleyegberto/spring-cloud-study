FROM openjdk:8-jdk-alpine

EXPOSE 8080

ARG environment
ENV SPRING_PROFILES_ACTIVE ${environment}

ADD target/spring-mvc.jar app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]