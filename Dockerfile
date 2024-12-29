FROM maven:3.9.4-eclipse-temurin-17 as build
WORKDIR /app
# Copy the parent POM first
COPY ./pom.xml .
# Copy the module directories with proper names
COPY "./Author and Book Microservice" "./Author and Book Microservice"
COPY ./LibraryManagementSystem ./LibraryManagementSystem
# Build
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
# Update the path to match the directory name
COPY --from=build "/app/Author and Book Microservice/target/*.jar" app.jar
EXPOSE 8999
ENTRYPOINT ["java", "-jar", "/app.jar"]
