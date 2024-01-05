* Need to create spring boot jars before running compose
  ```
  mvn clean package -DskipTests
  ```
  * other containers just pull images, just run
  * To copy in the jars either  
  ```
  docker-compose build
  //or use build flag
  docker-compose up -d --build
  ```
* Dockerfile template to build spring boot microservices read from root
  * needs to be at root for some reason. Get an error locating jar if moved to docker directory
* to run all containers
  ``` 
  docker-compose -f ./docker-compose.yml -f ./docker--zipkin-compose.yml -f ./docker-kafka-compose.yml [up -d | down]
  ```
* to run just spring services and mongo without zipkin, kafka
* currently stock service is dependent on mongo
  ```
  docker-compose up -d
  ```
* ELK stack needs to be started as a separate container because of file beat errors
  ```
  docker-compose -f ./elk/docker-compose.yml up -d
  ```
  Kowl to view kafka queue on localhost:8030
  ```
   docker run --network=external-network -p 8030:8080 -e KAFKA_BROKERS=broker:29092 quay.io/cloudhut/kowl:master
  ```


* notes
  * docker-compose files run all containers on custom network
  * this means kafka listener is same network so use port 29092
  * to view logs of containers docker logs <container_name> [-f] //-f = tail logs

* kafka commands
  * docker exec broker kafka-console-consumer --bootstrap-server localhost:9092 --topic fct.stock.quote --from-beginning
  * docker exec broker kafka-topics --bootstrap-server localhost:9092 --list
