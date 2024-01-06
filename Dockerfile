FROM amazoncorretto:17
ADD target/testApp-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar testApp-0.0.1-SNAPSHOT.jar