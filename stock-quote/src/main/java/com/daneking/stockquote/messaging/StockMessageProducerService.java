package com.daneking.stockquote.messaging;

import com.daneking.stockquote.StockQuote;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class StockMessageProducerService {
    public final static String TOPIC_NAME = "UpdatedStockEvent";

    private final KafkaTemplate<String, StockQuote> kafkaTemplate;

    public StockMessageProducerService(KafkaTemplate<String, StockQuote> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(StockQuote quote) {
        this.kafkaTemplate.send(TOPIC_NAME, quote);
    }
}
