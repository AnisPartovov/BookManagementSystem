FROM maven:3.9.4-eclipse-temurin-17 as build
WORKDIR /app
# Copy the parent POM first
COPY ./pom.xml .
# Copy the module directories
COPY ./AuthorandBookMicroservice ./AuthorandBookMicroservice
COPY ./LibraryManagementSystem ./LibraryManagementSystem
# Build
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
# Assuming AuthorandBookMicroservice is your main service
COPY --from=build /app/AuthorandBookMicroservice/target/*.jar app.jar
EXPOSE 8999
ENTRYPOINT ["java", "-jar", "/app.jar"]
