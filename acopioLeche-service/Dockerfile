FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} acopioLeche-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/acopioLeche-service-0.0.1-SNAPSHOT.jar"]