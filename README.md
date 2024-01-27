# spring-ref
Microservices examples from https://www.pentalog.com/blog/microservices-spring-boot-netflix-oss

* Build projects mvn clean package
* In order to run completely, you will need to create api.yml in stock-quote project, see project for details
* Docker -see Readme in docker folder
* To hit server thru api gateway you need to do localhost:8080/stock-quote/quotes



* TODO
  * ~~API Gateway seem broken~~
    * Look at adding auth here
  * Not sure stock quote still works 
  * Update Spring to 3.x
    * Replace Sleuth and Zipkin with Micrometer
      * Prefer opentelemetry bridge
  * Failing test believe its mongo 
  * Check out Apache/Spring Pulsar instead of Kafka
  * Config Server 
    * ~~initial setup~~
    * add to apps
    * ~~move import to profile yml file~~
      * ~~issue here https://github.com/spring-cloud/spring-cloud-config/issues/1877~~
  * ~~Mongo database~~
  * JWT/Auth new server or use gateway
    * Move api yml file
    * Move oauth stuff out of stock quote project
    * do I need an auth server or can I use gateway
      * gateway seems better approach but what are tradeoffs  
  * ~~Open telemetry - Cloud sleuth~~ 
    * ~~Collect info, ELK, Splunk, etc~~
  * Circuit Breaker
    * ~~add retry~~
    * add resilent4j or sentinel
    * fall back on api gateway
  * Spring health checks - use custom
  * Add integration tests, pact testing
    * embedded mongo locally 
    * Swagger Request validator
    * Test Containers
  * Testing
    * e2e
    * integration
  * Stock Quote
    * Had to remove Scheduler wiring
      * Look to replace with something in spring cloud
    * Openapi on endpoints
    * ~~Reactive request on stock quotes~~
    * ~~Scheduler grab stock quotes and send kafka~~
      * ~~trouble with autowire and mongo repo dependency~~ 
        * embedded mongo
      * Dynamic based on market open close
        * isMarketClosed Method
      * [stock quote client test](https://www.baeldung.com/spring-mocking-webclient)
  * News api
    * Need source, separate web scrapping?
      * May just create a news repository and figure out how to populate
    * [micronaut](https://guides.micronaut.io/latest/creating-your-first-micronaut-app-maven-java.html)
    * [quarkus](https://quarkus.io/get-started/)
  * Processor to analyze stock, maybe add flink/hazelcast
  * Alerting
  * UI Dashboard
  * Prometheus and Graphana
    * ~~initial setup~~ 
  * ~~Kafka integration test~~
    * ~~Used TestContainers~~
  * ~~Dockerize~~
  * ~~Upgrade Spring boot and Spring cloud to latest~~
