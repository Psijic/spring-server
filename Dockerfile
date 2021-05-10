FROM maven:alpine
MAINTAINER Viacheslav Alferov <psijic@gmail.com>

COPY ./build/libs/spring-server-0.0.1-SNAPSHOT.jar ./target/spring-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "./target/spring-server-0.0.1-SNAPSHOT.jar"]