# "connect" - spring boot application
This is a sample Java / Maven / Spring Boot (version 1.5.6) application that can be used as a starter for creating a microservice complete with built-in health check, metrics and much more.

## How to Run 

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
* After this just go to /kbc-online/kbc/src/main/java/com/kbc/KbcApplication.java and run it as java application
(there is option to run form cli also, but it reuires some dependency, willl update once I add the code for that too.)
*Please do check details in application.properties file for database details, change the driver and other details accordingly. I have used SQL (on docker image)

