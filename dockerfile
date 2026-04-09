FROM openjdk:8-jre-slim
WORKDIR /app
COPY target/MUL-1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
