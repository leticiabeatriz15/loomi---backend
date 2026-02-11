FROM maven:3.9.6-eclipse-temurin-21 AS build

COPY src /home/app/src
COPY pom.xml /home/app

WORKDIR /home/app
RUN mvn clean install -DskipTests

FROM eclipse-temurin:21-jdk-jammy

WORKDIR /home/app
COPY --from=build /home/app/target/*.jar app.jar

EXPOSE 3000
CMD ["java", "-jar", "app.jar"]