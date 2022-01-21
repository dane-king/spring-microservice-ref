# spring-ref
Microservices examples from https://www.pentalog.com/blog/microservices-spring-boot-netflix-oss

* Build projects mvn clean package
* Need to create api.yml in stock-quote project, see project for details
* Docker
  * change directory to docker
  * Run docker-compose build
  * all containers
    * docker-compose -f .\docker-compose.yml -f .\docker--zipkin-compose.yml -f .\docker-kafka-compose.yml [up -d | down]
  * just spring spring services without zipkin and kafka 
    * docker-compose up -d
* TODO
  * Config Server - need to use
  * JWT/Auth new server or use gateway
  * Open telemetry - Cloud sleuth 
    * Collect info, ELK, Splunk, etc
  * Circuit Breaker
  * Add integration tests, pact testing
    * Swagger Request validator
  * Add e2e tests
  * Stock Quote
    * Openapi on endpoints
    * Reactive request on stock quotes
    * Scheduler grab stock quotes and send kafka
      * Dynamic based on market open close
      * [stock quote client test](https://www.baeldung.com/spring-mocking-webclient)
  * Twitter api
    * [micronaut](https://guides.micronaut.io/latest/creating-your-first-micronaut-app-maven-java.html)
    * [quarkus](https://quarkus.io/get-started/)
  * Processor to read stocks off
  * Alerting
  * UI Dashboard
  * ~~Kafka integration test~~
    * ~~Used TestContainers~~
  * ~~Dockerize~~
  * ~~Upgrade Spring boot and Spring cloud to latest~~

