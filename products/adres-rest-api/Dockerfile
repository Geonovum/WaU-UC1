FROM maven:3-eclipse-temurin-17 as build

COPY ./ /src

RUN cd /src && \
    mvn package

FROM eclipse-temurin:17-jre-alpine

COPY --from=build /src/target/*-runnable.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

EXPOSE 8084
