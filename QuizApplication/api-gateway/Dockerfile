FROM maven:3.9.9-eclipse-temurin-21 as buidler
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTest

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=buidler /app/target/api-gateway.jar /app/api-gateway.jar
CMD ["java", "-jar", "/app/api-gateway.jar"]