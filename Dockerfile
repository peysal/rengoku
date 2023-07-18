# Use Red Hat's UBI 8 with OpenJDK 17 image as the base
FROM registry.access.redhat.com/ubi8/openjdk-17

LABEL authors="coders"

# Specify the work directory
WORKDIR /app

# Copy your fat jar to the container
COPY target/rengoku-0.0.1-SNAPSHOT.jar /app

# Command to start the Spring Boot application using java -jar
CMD ["java", "-jar", "/app/rengoku-0.0.1-SNAPSHOT.jar"]