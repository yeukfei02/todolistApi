# stage1
FROM gradle:6.3.0 AS build
RUN mkdir -p /home/gradle/src
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle ./ .
RUN gradle build --no-daemon

# stage2
FROM openjdk:15-jdk-slim
RUN mkdir -p /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/build/libs/todolistApi-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/build/libs/todolistApi-1.0.0.jar"]