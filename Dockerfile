# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app

# Copy source code and build it
COPY pom.xml .
COPY src ./src
RUN mvn clean package -U -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the built jar from the first stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

