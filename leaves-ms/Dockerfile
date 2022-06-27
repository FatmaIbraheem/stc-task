
FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} leaves.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","leaves.jar"]