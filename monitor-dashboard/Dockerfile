FROM openjdk:8-jre-alpine

COPY ./target/monitor-dashboard.jar monitor-dashboard.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./monitor-dashboard.jar"]

EXPOSE 7979