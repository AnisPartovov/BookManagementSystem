# Set the base image to Maven for building the application
FROM maven:3.9.4-eclipse-temurin-17 AS build
 
# Set the working directory for the build stage
WORKDIR /app
 
# Copy the entire project into the container
COPY . .
 
# Build the specified service using Maven
ARG SERVICE
RUN if [ -z "$SERVICE" ]; then echo "SERVICE argument not provided"; exit 1; fi \
&& mvn -f /app/$SERVICE/pom.xml clean package
 
# Set the base image for running the application
FROM eclipse-temurin:17
 
# Set the working directory for the runtime stage
WORKDIR /app
 
# Copy the built JAR file from the build stage
ARG SERVICE
COPY --from=build /app/$SERVICE/target/*.jar app.jar
 
# Expose the default application port
EXPOSE 8080
 
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]