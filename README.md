# spring-cloud-examples
Examples of microservice instrastructures

This project contains several examples of microservice infrastructures implemented with  Spring Boot and Spring Cloud projects.
The aim of each project is to provide an end to end example, being able to deploy it without too much hassle.

## Overview
Each folder represents a type of example (`config-provider`, `service-registry`, etc...) 
Each example is divided in subfolders, which are maven projects in charge of a specific service.
For example, for the `zuul-proxy-cloud-bus` example, we have the following folders:
- configuration-service
- eureka-service
- svca-service (one of the services with a custom business logic)
- svcb-service (another service with custom business logic)
- zuul-service
Each of them are deployed separately and together they form the microservice infrastructure for that example.

# Deployment
Each service could be deployed running the following:
`mvn spring-boot:run`

For example, for the microservice infrastructure declared on the project `zuul-proxy-cloud-bus` we will deploy the infrastructure doing the following:

- Deploy config-service
    ```
    cd configuration-service
    mvn spring-boot:run
    ```
- Deploy service a
    ```
    cd svca-service
    mvn spring-boot:run
    ```
- Deploy service b
    ```
    cd svcb-service
    mvn spring-boot:run
    ```
- Deploy Eureka service
    ```
    cd eureka-service
    mvn spring-boot:run
    ```
- Deploy Zuul proxy service
    ```
    cd zuul-service
    mvn spring-boot:run
    ```