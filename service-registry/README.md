# Eureka service registry
Examples of microservice instrastructures: Eureka service registry

## Blog post
For this example, a Service registry is used for locating the different services that are up and running on our microservice infrastructure.
Explanation of the architecture and purpose of having the Eureka service registry:
http://www.josedab.com/2016/02/19/microservices-using-eureka-as-a-service-registry/


## Overview
As you incorporate more and more services, locating them becomes more and more difficult and unmaintainable (imagine 500 microservices for example, how would you keep track of what is going on?).

On top of that, microservices are pieces of business logic that can be up/down changing their ip/status/address over the network.
Dns is very capable of solving that but it normally requires it to wait some time until the new services are resolved. Changes on addresses on the microservices should be reflected immediately and a good dns normally caches the information (for performance purposes for example).

For this example, we will create a service registry with Eureka and it will be showed also how to modify the microservices in order to be discovered.


## Deployment

Each maven subproject is a Spring Boot application. Running the example would be as easy as running the following:
`mvn spring-boot:run`
inside each of the suprojects.

The recommended way to deploy is:

- Deploy config-service
- Deploy service a
- Deploy service b
- Deploy Eureka service