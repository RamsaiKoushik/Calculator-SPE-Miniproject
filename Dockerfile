FROM openjdk:11

COPY ./target/demo-1.0-SNAPSHOT.jar ./

WORKDIR ./

CMD ["java", "-jar", "demo-1.0-SNAPSHOT.jar"]
