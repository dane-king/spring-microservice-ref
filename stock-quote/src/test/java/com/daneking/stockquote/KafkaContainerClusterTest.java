package com.daneking.stockquote;

import com.daneking.stockquote.config.KafkaConfig;
import com.daneking.stockquote.messaging.StockMessageProducerService;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.Test;
import org.rnorth.ducttape.unreliables.Unreliables;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class KafkaContainerClusterTest {


    @Test
    public void kafkaContainerClusterShouldWork() throws Exception {
        try (
            KafkaContainerCluster cluster = new KafkaContainerCluster("6.2.1", 3, 2)
        ) {
            cluster.start();
            String bootstrapServers = cluster.getBootstrapServers();

            assertThat(cluster.getBrokers()).hasSize(3);

            testKafkaFunctionality(bootstrapServers, 3, 2);
        }
    }
    private StockMessageProducerService getKafkaStockMessageProducerService(String bootStrapServers){
        KafkaConfig config= new KafkaConfig();
        ReflectionTestUtils.setField(config, "bootstrapServers", bootStrapServers);
        return new StockMessageProducerService(config.kafkaTemplate());
    }

    protected void testKafkaFunctionality(String bootstrapServers, int partitions, int rf) throws Exception {
        try (

            AdminClient adminClient = AdminClient.create(Map.of(
                AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers
            ));

            KafkaConsumer<String, String> consumer = new KafkaConsumer<>(
                Map.of(
                    ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
                    ConsumerConfig.GROUP_ID_CONFIG, "tc-" + UUID.randomUUID(),
                    ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"
                ),
                new StringDeserializer(),
                new StringDeserializer()
            )
        ) {
            String topicName = StockMessageProducerService.TOPIC_NAME;

            Collection<NewTopic> topics = Collections.singletonList(new NewTopic(topicName, partitions, (short) rf));
            adminClient.createTopics(topics).all().get(30, TimeUnit.SECONDS);

            consumer.subscribe(Collections.singletonList(topicName));
            StockMessageProducerService kafkaStockMessageProducerService = getKafkaStockMessageProducerService(bootstrapServers);
            StockQuote msg = new StockQuote("IBM", new BigDecimal("130.25"));
            kafkaStockMessageProducerService.send(msg);

            Unreliables.retryUntilTrue(10, TimeUnit.SECONDS, () -> {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

                if (records.isEmpty()) {
                    return false;
                }

                assertThat(records)
                    .hasSize(1)
                    .extracting(ConsumerRecord::topic, ConsumerRecord::key, ConsumerRecord::value)
                    .containsExactly(tuple(topicName, null, "{\"symbol\":\"IBM\",\"price\":130.25}"));
                return true;
            });

            consumer.unsubscribe();
        }
    }

}
