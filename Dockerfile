FROM openjdk:8-jdk-alpine

ADD target/splitwise-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java","-jar","app.jar"]