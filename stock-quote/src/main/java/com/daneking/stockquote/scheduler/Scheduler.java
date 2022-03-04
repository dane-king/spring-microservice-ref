package com.daneking.stockquote.scheduler;

import com.daneking.stockquote.messaging.StockMessageProducerService;
import com.daneking.stockquote.request.StockQuoteClient;
import com.daneking.stockquote.request.stock.StockList;
import com.daneking.stockquote.request.stock.StockListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Scheduler {
    private final StockQuoteClient client;
    private final StockMessageProducerService producerService;
    private final StockListRepository repository;

    public Scheduler(StockQuoteClient client, StockMessageProducerService producerService, StockListRepository repository) {
        this.client = client;
        this.producerService = producerService;
        this.repository = repository;
    }
    public void perform(){
        List<StockList> stockList = repository.findByOwner("kingd9");
        //TODO:map to list of symbols


    }
    public void perform(String symbol, String fields) {
        client.getStockQuote(symbol,fields).subscribe(producerService::send);
    }

}
