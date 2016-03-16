# Configuration service
Examples of microservice instrastructures: Configuration provider

## Blog post
For this example, a Configuration service is used for centralizing the configuration.
Explanation of the architecture and purpose of having a configuration service can be found here:
http://www.josedab.com/2016/02/16/microservices-writing-a-centralized-configuration-microservice/

## Overview
When implementing microservices, you can go for isolating the configuration for each service into its own project. To instantiate a service, we would need several properties like:

- Where the service is going to listen?
- Where do we store the additional properties?
- Do I need to communicate to other processes/services? If so, how do I connect to them without having hardcoded the information?

Main issues you can find with decentralized configuration are:
- Maintainability of configuration
- Inconsistency on properties
- Dynamic property refresh on microservices
- Each microservice deals with the configuration: duplication of code, no flexibility, etc...

Solving the issue of configuration inconsistency and maintainability on distributed systems and to act as a main point for configuration , we could go for the option of having a microservice for providing the configuration to the rest of the services.


## Deployment

Each maven subproject is a Spring Boot application. Running the example would be as easy as running the following:
`mvn spring-boot:run`
inside each of the suprojects.

The recommended way to deploy is:

- Deploy config-service
- Deploy service a
- Deploy service b
