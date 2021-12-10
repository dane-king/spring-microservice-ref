package com.daneking.stockquote.request;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class StockQuoteController {
    private final StockQuoteClient stockQuoteClient;

    public StockQuoteController(StockQuoteClient stockQuoteClient){
        this.stockQuoteClient = stockQuoteClient;
    }

    @GetMapping("/props")
    public Mono<String> getProps(){
        return this.stockQuoteClient.getValue("/market/ext/quotes.json?symbols=aapl");
    }
}
