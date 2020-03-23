FROM openjdk:8-jdk-alpine
MAINTAINER Sharansh Gupta <sharanshgupta@hotmail.com>

LABEL VERSION="0.0.1-SNAPSHOT"
LABEL DESCRIPTION="todo-in-memory"

ARG JAR_FILE=target/todo-in-memory-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]