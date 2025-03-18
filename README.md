# Record Store API

## Table of contents

- [Overview](#overview)
  - [MVP Requirements](#mvp-requirements)
- [My process](#my-process)
  - [Built with](#built-with)
  - [Continued development](#continued-development)
- [Author](#author)

## Overview

### MVP Requirements

**Simple album inventory and stock API**

Must-have features:

* list all albums in stock
* get album by id
* add new albums into the database
* update album details
* delete albums from the database

Nice-to-have features:

* list all albums by a given artist
* list all albums by a given release year
* list all albums by a given genre
* get album information by album name


## My process

## How to Run


Currently the default profile uses the in-memory H2 database. 

The `.gitignore` should ensure that only `.properties` files that do not contain sensitive data are tracked with git: 
```
### Spring Profiles ###
application-*.properties
#!application-dev.properties
```
To connect to a local Postgres database create an `application-dev.properties` or `application-prod.properties` file in the `resources` folder and add the following: 
```
spring.datasource.url=jdbc:postgresql://localhost:5432/[your local db name]
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=[your username]
spring.datasource.password=[your password]
```
To switch profiles uncomment the following in `application.properties` (replace 'dev' with 'prod' if necessary):
```
#spring.profiles.active=dev
```
The `resources` folder contains the `import.sql` script which is executed when Hibernate creates the schema.
For demonstration and development purposes the database is populated with initial album data from the `data.sql` file. 

For more information on database initialisation see the official [Spring docs](https://docs.spring.io/spring-boot/how-to/data-initialization.html).

Add the following to your active profile: 
```
springdoc.swagger-ui.path=/api/v1/swagger-ui.html
management.endpoint.health.enabled=true

logging.level.org.springframework.web=debug
spring.http.log-request-details=true
```
To view the [Health](https://docs.spring.io/spring-boot/api/rest/actuator/health.html) endpoint, open [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health) in a browser. 

To visualise and interact with the api using Swagger, open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in a browser.


### Built with

- Java
- Spring Boot
- H2 Database (for development)
- PostgreSQL
- JUnit
- Mockito

### Continued development

- More test coverage
- Deploy with Docker and AWS
- Implement OAuth 2.0


## Author

- Github - [Lexadecimals](https://github.com/lexadecimals)
