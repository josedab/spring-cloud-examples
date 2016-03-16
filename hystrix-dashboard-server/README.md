# Hystrix dashboard with Turbine
Examples of microservice instrastructures: Hystrix dashboard

## Blog post
For this example, a Hystrix dashboard is going to be created in order to monitor connection between services.
Explanation of the architecture and purpose of having a Hystrix dashboard service can be found here:
http://www.josedab.com/2016/03/05/microservices-hystrix-dashboard-detecting-point-of-failures/

## Overview
When specifying callback strategies and proxying to an increasing number of microservices it would be good to have some kind of monitoring.

Using Zuul let us to create a stream of data related to the connections that are proxied. This data can be rendered by a Hystrix dashboard.

## Deployment

Each maven subproject is a Spring Boot application. Running the example would be as easy as running the following:
`mvn spring-boot:run`
inside each of the suprojects.

The recommended way to deploy is:

- Deploy config-service
- Deploy service a
- Deploy service b
- Deploy Eureka service
- Deploy Zuul proxy service
- Deploy Hystrix dashboard service
