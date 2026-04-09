# Use Eclipse Temurin (the replacement for the old openjdk image)
FROM eclipse-temurin:8-jre-focal

WORKDIR /app

# Ensure the JAR filename matches exactly what is in your /target folder
COPY target/MUL-1.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
