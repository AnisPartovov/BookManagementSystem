# Build stage
FROM maven:3.8.4-openjdk-17 AS builder

# Set working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the projects
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17-slim

WORKDIR /app

# Environment variable for selecting which service to run
ARG SERVICE=author-book-service
ENV SERVICE=${SERVICE}

# Copy JARs from builder stage (using proper escaping for spaces)
COPY --from=builder "/app/AuthorandBookMicroservice/target/*.jar" /app/author-book-service.jar
COPY --from=builder "/app/LibraryManagementSystem/target/*.jar" /app/library-management-system.jar

# Expose default application port
EXPOSE 8080

# Default command to run the selected microservice
ENTRYPOINT ["sh", "-c", "java -jar /app/${SERVICE}.jar"]