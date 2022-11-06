# Use an OpenJDK Runtime as a parent image
FROM openjdk:8-jdk-alpine
# Set the working directory to /app
WORKDIR /app
# Copy the executable into the container at /app
ADD target/*.jar app.jar
# Make port 9091 available to the world outside this container
EXPOSE 9091
# Run app.jar when the container launches
CMD ["java", "-jar", "/app/app.jar"] 
#CMD mvn spring-boot:run 
