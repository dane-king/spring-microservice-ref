package com.daneking.stockquote;

import com.daneking.stockquote.messaging.StockMessageProducerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rnorth.ducttape.unreliables.Unreliables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;


@Testcontainers
@SpringBootTest
@Slf4j
@ActiveProfiles("test")
public class KafkaProducerIntegrationTest {

    @Value("${spring.kafka.consumer.timeout:10}")
    private Integer timeout;
    @Autowired
    private KafkaTemplate<String, StockQuote> template;

    private StockMessageProducerService producer;

    @BeforeEach
    void setUp() {
        template.getProducerFactory().updateConfigs(Map.of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers()
        ));
        producer=new StockMessageProducerService(template);
    }

    @Container
    public static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka"));


    private StockQuote sendStockQuote() {
        StockQuote msg = new StockQuote();
        msg.setSymbol("IBM");
        msg.setLast("130.25");
        producer.send(msg);
        return msg;
    }

    @Test
    protected void testKafkaFunctionality() throws Exception {
        //need to get bootstrap cause containers change
        String bootstrapServers = kafka.getBootstrapServers();
        //build consumer
        try (

                AdminClient adminClient = AdminClient.create(Map.of(
                        AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers
                ));
                KafkaConsumer<String, StockQuote> consumer = new KafkaConsumer<>(
                        Map.of(
                                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
                                ConsumerConfig.GROUP_ID_CONFIG, "tc-" + UUID.randomUUID(),
                                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"
                        ),
                        new StringDeserializer(),
                        new JsonDeserializer<>(StockQuote.class)
                )

        ) {
            String topicName = StockMessageProducerService.TOPIC_NAME;

            Collection<NewTopic> topics = Collections.singletonList(new NewTopic(topicName, 1, (short) 1));
            adminClient.createTopics(topics).all().get(30, TimeUnit.SECONDS);

            consumer.subscribe(Collections.singletonList(topicName));

            StockQuote msg=sendStockQuote();

            Unreliables.retryUntilTrue(timeout, TimeUnit.SECONDS, () -> {
                ConsumerRecords<String, StockQuote> records = consumer.poll(Duration.ofMillis(100));

                if (records.isEmpty()) {
                    return false;
                }
                log.info("Received are {}", records.toString());
                assertThat(records)
                        .hasSize(1)
                        .extracting(ConsumerRecord::topic, ConsumerRecord::key, ConsumerRecord::value)
                        .containsExactly(tuple(topicName, "IBM", msg));
                return true;
            });

            consumer.unsubscribe();
        }
    }

}