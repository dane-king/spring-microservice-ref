package com.daneking.processor.listener;

import com.daneking.processor.StockQuote;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StockConsumer {
    private ConsumerRecord<String, StockQuote> payload = null;

    @KafkaListener(topics = "fct.stock.quote")
    public void receive(ConsumerRecord<String, StockQuote> consumerRecord) {
        log.info("received payload='{}'", consumerRecord.toString());
        payload=consumerRecord;
    }

    public ConsumerRecord<String,StockQuote> getPayload() {
        return payload;
    }




}
