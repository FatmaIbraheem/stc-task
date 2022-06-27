
FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} employee.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","employee.jar"]