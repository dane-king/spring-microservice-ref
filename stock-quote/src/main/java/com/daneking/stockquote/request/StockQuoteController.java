package com.daneking.stockquote.request;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StockQuoteController {
    private final StockQuoteClient stockQuoteClient;
    private final String fields;
    private String symbols;

    public StockQuoteController(StockQuoteClient stockQuoteClient,
                                @Value("${stock.symbols:AAPL}") String symbols,
                                @Value("${stock.flds:symbol,ask,bid,vl}") String fields){
        this.stockQuoteClient = stockQuoteClient;
        this.symbols = symbols;
        this.fields=fields;
    }

    @GetMapping("/props")
    public Mono<String> getProps(){
        String paths = String.format("/market/ext/quotes.json?symbols=%s&fids=%s",symbols,fields);
        return this.stockQuoteClient.getValue(paths);
    }
}
