FROM openjdk:8-jdk-slim
LABEL maintainer=wanfeng
COPY target/QQReboot-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-Dmirai.no-desktop","-jar","/app.jar"]
