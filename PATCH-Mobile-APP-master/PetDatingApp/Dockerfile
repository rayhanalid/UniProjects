## Use the official OpenJDK base image
#FROM openjdk:20-jdk-slim
#
## Set the working directory
#WORKDIR /
#
## Copy the JAR file of your Spring Boot app to the container
#COPY target/PetDatingApp-0.0.1-SNAPSHOT.jar /app.jar
## Copy the JSON token file to the container
#COPY src/main/resources/PATCH-CREDENTIALS.json /
##ADD src/main/resources/PATCH-CREDENTIALS.json /
#
#
#ENTRYPOINT ["java", "-jar"]
#
## Expose the port that your Spring Boot app is listening on
#EXPOSE 8080
#
## Run the Spring Boot app
#CMD ["/app.jar"]
#
# Use the official OpenJDK base image
# Use the official OpenJDK base image
# Use the official OpenJDK base image
FROM openjdk:20-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file of your Spring Boot app to the container
COPY target/PetDatingApp-0.0.1-SNAPSHOT.jar /app.jar

# Copy the JSON token file to the container's resources directory
COPY src/main/resources/PATCH-CREDENTIALS.json /app/resources/PATCH-CREDENTIALS.json

ENTRYPOINT ["java", "-jar"]

# Expose the port that your Spring Boot app is listening on
EXPOSE 8080

# Run the Spring Boot app
CMD ["/app.jar"]
