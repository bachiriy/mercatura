FROM openjdk:8-jdk-alpine
# LABEL maintainer="author@javatodev.com"
MAINTAINER baeldung.com
# VOLUME /api
COPY target/api-0.0.1-SNAPSHOT.jar api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/api-0.0.1-SNAPSHOT.jar", "-XX:+TieredCompilation","-XX:TieredStopAtLevel=1"]