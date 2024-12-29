FROM maven:3.9.4-eclipse-temurin-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
COPY --from=build /app/AuthorandBookMicroservice/target/*.jar app.jar
EXPOSE 8999
ENTRYPOINT ["java", "-jar", "/app.jar"]