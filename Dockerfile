# Use a base image with Java installed
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/your-application.jar /app/your-application.jar

# Specify the command to run your application
CMD ["java", "-jar", "your-application.jar"]
