FROM openjdk:8-jre

ADD ./build/libs/inventory-service-1.0-SNAPSHOT.jar /service/
CMD ["java", "-Xmx200m", "-DlogPath=/logs", "-jar", "/service/inventory-service-1.0-SNAPSHOT.jar"]

EXPOSE 8081
