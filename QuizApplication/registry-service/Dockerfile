# Step 1: Build stage
FROM maven:3.9.9-eclipse-temurin-21 as builder
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests  # Build the JAR file

# Step 2: Runtime stage
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/registry_service.jar /app/registry_service.jar
CMD ["java", "-jar", "/app/registry_service.jar"]