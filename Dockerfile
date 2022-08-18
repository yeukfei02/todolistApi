# stage1
FROM gradle:7.5.0-jdk8 AS build
RUN mkdir -p /home/gradle/src
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle ./ .
RUN gradle build --no-daemon

# stage2
FROM openjdk:11.0.15
RUN mkdir -p /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/build/libs/todolistApi-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/build/libs/todolistApi-1.0.0.jar"]
