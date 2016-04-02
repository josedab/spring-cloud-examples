# spring-cloud-examples
Examples of microservice instrastructures

This project contains several examples of microservice infrastructures implemented with  Spring Boot and Spring CLoud projects.
The aim of each project is to provide an end to end example, being able to deploy it without too much hassle.

## Overview
Each folder represents a type of example. Each example is divided in subfolders, which are maven projects in charge of a specific service.
The services that are contemplated during the examples are:
- Configuration service
- Eureka service registry
- Zuul edge service
- Hystrix dashboard
- Zipkin service

# Deployment
Each service could be deployed running the following:
`mvn spring-boot:run`
