* run from this directory
* Run docker-compose build
* all containers
    * docker-compose -f .\docker-compose.yml -f .\docker--zipkin-compose.yml -f .\docker-kafka-compose.yml [up -d | down]
* to run just spring services without zipkin and kafka
    * docker-compose up -d

* notes
  * docker-compose files run all containers on custom network
  * this means kafka listener is same network so use port 29092
  * to view logs of containers docker logs <container_name> [-f] //-f = tail logs

* kafka commands
  * docker exec broker kafka-console-consumer --bootstrap-server localhost:9092 --topic fct.stock.quote --from-beginning
  * docker exec broker kafka-topics --bootstrap-server localhost:9092 --list
