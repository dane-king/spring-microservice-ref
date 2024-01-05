# spring-ref
Microservices examples from https://www.pentalog.com/blog/microservices-spring-boot-netflix-oss

* Build projects mvn clean package
* In order to run completely, you will need to create api.yml in stock-quote project, see project for details
* Docker -see Readme in docker folder



* TODO
  * Update Spring to 3.x
  * Failing test believe its mongo   
  * Config Server - need to use
  * ~~Mongo database~~
  * JWT/Auth new server or use gateway
    * Move oauth stuff out of stock quote project
    * do I need an auth server or can I use gateway
      * gateway seems better approach but what are tradeoffs  
  * ~~Open telemetry - Cloud sleuth~~ 
    * ~~Collect info, ELK, Splunk, etc~~
  * Circuit Breaker
  * Spring health checks
  * Add integration tests, pact testing
    * embedded mongo locally 
    * Swagger Request validator
    * Test Containers
  * Add e2e tests
  * Stock Quote
    * Openapi on endpoints
    * ~~Reactive request on stock quotes~~
    * ~~Scheduler grab stock quotes and send kafka~~
      * Dynamic based on market open close
      * [stock quote client test](https://www.baeldung.com/spring-mocking-webclient)
  * Twitter api
    * [micronaut](https://guides.micronaut.io/latest/creating-your-first-micronaut-app-maven-java.html)
    * [quarkus](https://quarkus.io/get-started/)
  * Processor to read stocks off, or something like flink
  * Alerting
  * UI Dashboard
  * Prometheus and Graphana
  * ~~Kafka integration test~~
    * ~~Used TestContainers~~
  * ~~Dockerize~~
  * ~~Upgrade Spring boot and Spring cloud to latest~~
