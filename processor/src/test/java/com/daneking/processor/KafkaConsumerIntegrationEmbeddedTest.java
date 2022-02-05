package com.daneking.processor;

import com.daneking.processor.listener.StockConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testcontainers.shaded.org.awaitility.Awaitility.waitAtMost;


@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
@ActiveProfiles("test")
@Ignore //Embedded Kafka does not work with this version in Windows
public class KafkaConsumerIntegrationEmbeddedTest {
    private final String topicName = "fct.stock.quote";

    @Value("${spring.kafka.consumer.timeout:10}")
    private Integer timeout;

    @Autowired
    private StockConsumer consumer;


    private StockQuote sendStockQuote() {
        StockQuote msg = new StockQuote();
        msg.setSymbol("IBM");
        msg.setLast("130.25");
        //producer.send(msg);
        return msg;
    }

    @Test
    protected void testKafkaFunctionality() throws Exception {
        try (
                KafkaProducer<String,StockQuote> producer = new KafkaProducer<>(
                        Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "PLAINTEXT://localhost:9092"),
                        new StringSerializer(),
                        new JsonSerializer<>()
                );

        ) {
            StockQuote msg=sendStockQuote();
            ProducerRecord<String,StockQuote> record=new ProducerRecord<>("IBM", msg);
            producer.send(record);

            waitAtMost(timeout, TimeUnit.SECONDS).until((()->consumer.getPayload()!=null));
            assertThat(consumer.getPayload().value(), CoreMatchers.equalTo(msg));


        }
    }

}