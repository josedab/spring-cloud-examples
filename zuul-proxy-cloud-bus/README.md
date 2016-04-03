# Zuul proxy microservice
Examples of microservice instrastructures: Zuul proxy

## Blog post
For this example, a Zuul proxy used as edge service will be incorporated.
Explanation of the architecture and purpose of having a Zuul proxy:
http://www.josedab.com/2016/03/01/microservices-using-zuul-proxy-as-a-micro-proxy-and-api-gateway/

## Overview
Zuul service proxying GET and POST requests. 
On top of proxying requests, distributed messaging is incorporated to access multiple ends without having to locate each of the services (In this case service A and B)

## Deployment

Each maven subproject is a Spring Boot application. Running the example would be as easy as running the following:
`mvn spring-boot:run`
inside each of the suprojects.

The recommended way to deploy is:

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

## Test
On the console, you could run `jps`. This would show the java processes. An output of the services runing could be:
```
1264 ConfigurationServiceApplication
1265 EurekaServiceApplication
1266 SvcAServiceApplication
1267 SvcBServiceApplication
1268 ZuulProxyClientApplication
```

### Urls
To hit the services deployed, you could try the following urls:
- Zuul service health status [http://localhost:9000/health]
- Microservice A
  - Through Zuul proxy [http://localhost:9000/svca-service]
  - Endpoint to service A: [http://localhost:9000/svca-service/socialProfiles]
  - Url of the service [http://localhost:5000]
  - Endpoint to service A: http://localhost:5000/socialProfiles
- Microservice B
  - Through Zuul proxy [http://localhost:9000/svcb-service]
  - Endpoint to service B [http://localhost:9000/svcb-service/socialProfiles]
  - Url of the service [http://localhost:7000]
  - Endpoint to service A [http://localhost:7000/socialProfiles]
- Composition of services
  - Endpoint for composition of service A and B: http://localhost:9000/profiles/names
- Eureka service registry [http://localhost:8761]