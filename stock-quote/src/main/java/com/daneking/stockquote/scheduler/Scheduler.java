package com.daneking.stockquote.scheduler;

import com.daneking.stockquote.messaging.StockMessageProducerService;
import com.daneking.stockquote.request.StockQuoteClient;
import org.springframework.stereotype.Service;

@Service
public class Scheduler {
    private final StockQuoteClient client;
    private final StockMessageProducerService producerService;

    public Scheduler(StockQuoteClient client, StockMessageProducerService producerService) {
        this.client = client;
        this.producerService = producerService;


    }

    public void perform(String paths) {
        client.getStockQuote(paths).subscribe(producerService::send);
    }

}
