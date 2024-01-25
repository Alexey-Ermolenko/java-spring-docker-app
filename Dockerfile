FROM amazoncorretto:17
ADD target/testApp-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar testApp-0.0.1-SNAPSHOT.jar
#CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "testApp-0.0.1-SNAPSHOT.jar"]