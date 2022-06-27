
FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} discovery.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","discovery.jar"]