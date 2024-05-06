FROM gradle:8.4 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test

FROM eclipse-temurin:17-jre-alpine
WORKDIR /src
COPY --from=build /home/gradle/src/build/libs/J2024-MAI-Backend-A-Nosov-1.0-SNAPSHOT.jar ./
CMD ["java","-jar","J2024-MAI-Backend-A-Nosov-1.0-SNAPSHOT.jar"]

