FROM openjdk:17-oracle
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]