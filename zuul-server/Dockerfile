FROM openjdk:8-jre-alpine

COPY ./target/zuul-server.jar zuul-server.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./zuul-server.jar"]

EXPOSE 8080