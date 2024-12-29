FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .

COPY src/ ./src

RUN mvn clean package

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]


# Stage 1: Build the application

FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copy the parent directory into the container

COPY . .

# Dynamically build the selected microservice

ARG SERVICE

WORKDIR /app/$SERVICE

RUN mvn clean package

# Stage 2: Run the application

FROM openjdk:17-jdk-slim

WORKDIR /app

# Dynamically copy the correct JAR file

ARG SERVICE

COPY --from=build /app/$SERVICE/target/*.jar app.jar

# Expose default application port

EXPOSE 8080

# Default command to run the selected microservice

ENTRYPOINT ["java", "-jar", "app.jar"]

