FROM openjdk:17-alpine
ARG JAR_FILTE=target/*.jar
COPY ./target/SpringAPI-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]