FROM openjdk:11-jdk
ARG JAR_FILE=build/libs/*.jar app.jap
COPY ${JAR_FILE} app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/app.jar"]