FROM openjdk:8-jre-alpine

COPY ./target/turbine-streamer.jar turbine-streamer.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./turbine-streamer.jar"]

EXPOSE 8989
EXPOSE 8990