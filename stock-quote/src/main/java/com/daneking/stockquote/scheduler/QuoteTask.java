package com.daneking.stockquote.scheduler;

import com.daneking.stockquote.StockQuote;
import com.daneking.stockquote.messaging.StockMessageProducerService;
import com.daneking.stockquote.request.StockQuoteClient;
import com.daneking.stockquote.request.stock.StockListService;
import com.daneking.stockquote.request.stock.StockTicker;
import com.daneking.stockquote.request.stock.model.StockList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Lazy
public class QuoteTask implements  Runnable{
    private static final String FIELDS = "symbol,name, datetime,last,vl,adp_50,adp_100,adp_200";

    //TODO add @Value here
    private static final String OWNER = "kingd9";

    private final StockQuoteClient client;
    private final StockMessageProducerService producerService;
    private final String symbols;

    public QuoteTask(StockQuoteClient client, StockMessageProducerService producerService, StockListService stockListService) {
        this.client = client;
        this.producerService = producerService;
        this.symbols= getSymbols(stockListService.getStockListsFor(OWNER));
    }

    @Override
    public void run() {
        log.info("Getting Quotes for symbols {} with fields {}", symbols, FIELDS);
        Flux<StockQuote> stockQuote = client.getStockQuote(symbols, FIELDS);
        log.info("Sending to Queue");
        stockQuote.subscribe(producerService::send);
    }

    private String getSymbols(List<StockList> stockList) {
        return stockList.stream()
                .map(StockList::getStocks)
                .flatMap(List::stream)
                .map(StockTicker::getSymbol)
                .collect(Collectors.joining(","));
    }

}
