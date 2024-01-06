# Java Docker Web Application Template
### Web application for car service with several features. 
#### Technologies used in this project:
* Spring Boot,
* Spring MVC,
* Thymeleaf,
* Spring Data,
* Spring Security,
* JPA,
* HTTP,
* CSS,
* Bootstrap

#### Delete all existing docker images:
* `docker stop $(docker ps -aq)`
* `docker rm $(docker ps -aq)`
#### Docker create image:
* `docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=testapp --rm -d mysql`
#### Make a build app 
Command example:

`C:\Users\aoerm\.jdks\corretto-17.0.3\bin\java.exe -Dmaven.multiModuleProjectDirectory=C:\projects\java\java-docker-template-project -Dmaven.home=C:\Users\aoerm\.m2\wrapper\dists\apache-maven-3.8.4-bin\52ccbt68d252mdldqsfsn03jlf\apache-maven-3.8.4 -Dclassworlds.conf=C:\Users\aoerm\.m2\wrapper\dists\apache-maven-3.8.4-bin\52ccbt68d252mdldqsfsn03jlf\apache-maven-3.8.4\bin\m2.conf "-Dmaven.ext.class.path=C:\Program Files\JetBrains\IntelliJ IDEA 2022.1.2\plugins\maven\lib\maven-event-listener.jar" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2022.1.2\lib\idea_rt.jar=64604:C:\Program Files\JetBrains\IntelliJ IDEA 2022.1.2\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\aoerm\.m2\wrapper\dists\apache-maven-3.8.4-bin\52ccbt68d252mdldqsfsn03jlf\apache-maven-3.8.4\boot\plexus-classworlds-2.6.0.jar;C:\Users\aoerm\.m2\wrapper\dists\apache-maven-3.8.4-bin\52ccbt68d252mdldqsfsn03jlf\apache-maven-3.8.4\boot\plexus-classworlds.license org.codehaus.classworlds.Launcher -Didea.version=2022.1.2 clean validate compile test package`


#### Docker compose:
* `docker-compose up --build`
* `docker-compose down1`
* `docker-compose start`
* `docker-compose stop`
