package com.daneking.stockquote.scheduler;

import com.daneking.stockquote.messaging.StockMessageProducerService;
import com.daneking.stockquote.request.StockQuoteClient;
import com.daneking.stockquote.request.stock.StockList;
import com.daneking.stockquote.request.stock.StockListRepository;
import com.daneking.stockquote.request.stock.StockTicker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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
        String symbols = stockList.stream()
                .map(StockList::getStocks)
                .flatMap(List::stream)
                .map(StockTicker::getSymbol)
                .collect(Collectors.joining(","));
        log.info("Getting quotes for {}", symbols);
        perform(symbols,"symbol,name, datetime,last,vl,adp_50,adp_100,adp_200");
    }
    public void perform(String symbol, String fields) {
        client.getStockQuote(symbol,fields).subscribe(producerService::send);
    }

}
