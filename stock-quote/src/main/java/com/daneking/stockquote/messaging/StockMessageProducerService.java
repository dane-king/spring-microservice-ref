package com.daneking.stockquote.messaging;

import com.daneking.stockquote.StockQuote;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Lazy
public class StockMessageProducerService {
    public final static String TOPIC_NAME = "fct.stock.quote";

    private final KafkaTemplate<String, StockQuote> kafkaTemplate;

    public StockMessageProducerService(KafkaTemplate<String, StockQuote> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(StockQuote quote) {
        this.kafkaTemplate.send(TOPIC_NAME, quote);
    }


    /**
     * Sends Stockstock quotes to queue
     * @param quotes Flux emitter of StockQuotes
     */
    public void send(Flux<StockQuote> quotes){
        quotes.subscribe(this::send);
    }
}
