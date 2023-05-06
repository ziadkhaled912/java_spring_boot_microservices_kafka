FROM openjdk:17 as builder
WORKDIR /app
COPY . .

# Refer to Maven build -> finalName
ARG JAR_FILE=target/customer-1.0-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/{jarfileName}.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
FROM openjdk:17
COPY --from=builder /app/app.jar .
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
