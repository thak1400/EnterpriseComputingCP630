# Spring Boost MVC
Author: HBF  
Date: 2020-10-18 (update)  

## About this project

This project is to get hand on 

- Spring Boot for stand alone web server with JSP component 
- Spring controller for GET and POST HTTP requests

## Run within Eclipse

1. Run App.java as Java application
2. Test by the following URL 

- [http://localhost:8080/json/ec](http://localhost:8080/json/ec)
- [http://localhost:8080/xml/ec](http://localhost:8080/xml/ec)
- [http://localhost:8080/ec-spring](http://localhost:8080/ec-spring)
- [http://localhost:8080/ec-spring?name=EC](http://localhost:8080/ec-spring?name=EC)
- [http://localhost:8080/ec-spring2](http://localhost:8080/ec-spring2)
- [http://localhost:8080/ec-spring2?name=EC](http://localhost:8080/ec-spring2?name=EC)
- [http://localhost:8080/post-form](http://localhost:8080/post-form)
- [http://localhost:8080/ec-spring3](http://localhost:8080/ec-spring3)
- [http://localhost:8080//login](http://localhost:8080/login)   username:admin password:cp630


## Standalone program

1. Open cmd console, cd to the folder of ec-spring-boot-jsp.
2. Run Maven command: mvn clean package
3. Run command: java -jar target/ec-spring-boot-jsp.jar this will start a web server.
4. Test using as the above.  


## Read files 

- src/main/resources/application.properties contains the configuraion for using jsp 
- src/main/webapp/WEB-INF/jsp  contains jsp pages  
- pom.xml contains the following two dependents for jsp

~~~
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
	<scope>provided</scope>
</dependency>
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>jstl</artifactId>
</dependency>
~~~

**Note** JSP and Thymeleaf pages should not be in the same project. 

