FROM openjdk:21-jdk-slim

WORKDIR /app

COPY mvnw .
COPY .mvn ./.mvn
COPY pom.xml .

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw package -DskipTests

RUN sh -c 'mv target/*.jar app.jar'

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]