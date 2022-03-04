package com.daneking.processor;

import com.daneking.processor.listener.StockConsumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testcontainers.shaded.org.awaitility.Awaitility.waitAtMost;


@Import(KafkaProducerConsumerIntegrationTest.KafkaTestContainersConfiguration.class)
@Testcontainers
@SpringBootTest
@Slf4j
@ActiveProfiles("test")
public class KafkaProducerConsumerIntegrationTest {

    @Value("${spring.kafka.consumer.timeout:10}")
    private Integer timeout;

    @Autowired
    private StockConsumer consumer;

    @Autowired
    public KafkaTemplate<String, StockQuote> template;

    @Container
    public static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka"));


    private StockQuote sendStockQuote() {
        StockQuote msg = new StockQuote();
        msg.setSymbol("IBM");
        msg.setLast("130.25");
        return msg;
    }

    @Test
    void givenKafkaDockerContainer_whenSendingtoDefaultTemplate_thenMessageReceived() throws Exception {
        StockQuote expectedMsg = sendStockQuote();
        template.send("fct.stock.quote", expectedMsg);

        waitAtMost(timeout, TimeUnit.SECONDS).until((()->consumer.getPayload()!=null));
        assertThat(consumer.getPayload().value(),equalTo(expectedMsg));
    }

    @TestConfiguration
    static class KafkaTestContainersConfiguration {

        @Bean
        ConcurrentKafkaListenerContainerFactory<String, StockQuote> kafkaListenerContainerFactory() {
            ConcurrentKafkaListenerContainerFactory<String, StockQuote> factory = new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(consumerFactory());
            return factory;
        }

        @Bean
        public ConsumerFactory<String, StockQuote> consumerFactory() {
            return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new JsonDeserializer<>(StockQuote.class));
        }

        @Bean
        public Map<String, Object> consumerConfigs() {
            return Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers(),
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest",
                ConsumerConfig.GROUP_ID_CONFIG, "dane-king"
            );
        }

        @Bean
        public ProducerFactory<String, StockQuote> producerFactory() {
            Map<String, Object> configProps = new HashMap<>();
            configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
            configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
            return new DefaultKafkaProducerFactory<>(configProps);
        }

        @Bean
        public KafkaTemplate<String, StockQuote> kafkaTemplate() {
            return new KafkaTemplate<>(producerFactory());
        }

    }

}