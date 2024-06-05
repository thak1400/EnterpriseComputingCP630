# Spring Boost MVC+JSP+JPA
Author: HBF  
Date: 2022-06-2  

## About this project

This project is to get hand on 

- Spring Boot for stand alone web server with JSP and JPA
- Spring controller for GET and POST HTTP requests

This project require the MySQL and ECUser database.

## Run within Eclipse

1. Run App.java as Java application
2. Open URL [http://localhost:8080/list-user](http://localhost:8080/list-user). Note that it lists users in table ecuser on MySQL. Make sure MySQL is running and has the table with records. 


## Standalone program

1. Open cmd console, cd to the folder of ec-spring-boot-jsp.
2. Run Maven command: mvn clean package
3. Run command: java -jar target/ec-spring-boot-jpa.jar to start a standalone web server.
4. Open URL [http://localhost:8080/list-user](http://localhost:8080/list-user). 


## Read files 

- src/main/resources/application.properties contains the configuraion for using jsp 
- src/main/webapp/WEB-INF/jsp  contains jsp pages
- src/main/java/ec/lab/  contains the User entity    
- pom.xml contains the following two dependents for JDBC and JPA

~~~
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<scope>runtime</scope>
</dependency>
~~~


## Reference

1. [Getting started with Spring Data JPA](https://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa)

