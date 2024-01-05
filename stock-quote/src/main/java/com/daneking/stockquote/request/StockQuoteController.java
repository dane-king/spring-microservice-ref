package com.daneking.stockquote.request;

import com.daneking.stockquote.StockQuote;
import com.daneking.stockquote.scheduler.Scheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.apache.commons.lang.StringUtils.defaultIfEmpty;


@RestController
@Slf4j
public class StockQuoteController {
    private final StockQuoteClient stockQuoteClient;
    private final String fields;
    private final String symbols;

    public StockQuoteController(StockQuoteClient stockQuoteClient,
                                @Value("${stock.symbols:AAPL}") String symbols,
                                @Value("${stock.fields:symbol,datetime,last,vl,adp_50,adp_100,adp_200}") String fields) {
        this.stockQuoteClient = stockQuoteClient;
        this.symbols = symbols;
        this.fields = fields;
    }

    @GetMapping("/quotes")
    public Flux<StockQuote> getQuotes(@RequestParam(required = false, name = "symbols") String symbols_param, @RequestParam(required = false, name = "fields") String fields_param) {
        log.info("Path is built from {} and {}", symbols_param, fields_param);
        return this.stockQuoteClient.getStockQuote(defaultIfEmpty(symbols_param,this.symbols), defaultIfEmpty(fields_param,this.fields));
    }

    @GetMapping("/market")
    public Mono<String> isMarketClosed() {
        return this.stockQuoteClient.getMarket("/market/clock.json");
    }

    @GetMapping("/send/{owner}")
    public String addToQueue(@PathVariable String owner) throws Exception {
        //scheduler.perform("F,IBM", "symbol,datetime,last,vl");
        return "send quotes to queue";
    }

}
