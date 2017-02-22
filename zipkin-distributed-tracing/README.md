# spring-cloud-examples
Examples of microservice instrastructures: Zipkin

http://www.josedab.com/2016/03/09/microservices-zipkin-distributed-tracing/

For this example, the incorporation of the Zipkin stream server will allow us to receive http traces that later can be shown through the Zipkin Web UI.
After reading the 8 fallacies of distributed computing, you definitely want some monitoring or analysis tool that tells you what is going on with your http requests.
The more complex the system is, the more need of tools for analyzing what is going on on the communication between services.

## Deployment

Each maven subproject is a Spring Boot application. Running the example would be as easy as running the following:
`mvn spring-boot:run`
inside each of the suprojects.

The recommended way to deploy is:

- Deploy Kafka on the default ports. We use it for the cloud streaming messages propagated to the zipkin stream server.
```
~/kafka_2.11-0.10.1.0$ bin/zookeeper-server-start.sh configookeeper.properties
~/kafka_2.11-0.10.1.0$ bin/kafka-server-start.sh config/server.properties
```
- Deploy config-service
- Deploy service a
- Deploy service b
- Deploy Eureka service
- Deploy Zuul proxy service
- Deploy Zipkin server
- Deploy Zipkin web ui pointing to the Zipkin stream server:
- Download the Zipkin web ui from the build . For this example, I downloaded zipkin-web-1.28.1-20160104.090947-7-all.jar , although you could use any newer version.
java -jar zipkin-web-1.28.1-20160104.090947-7-all.jar  
     -zipkin.web.port=localhost:9401 
     -zipkin.web.rootUrl=/ 
     -zipkin.web.query.dest=localhost:9411
