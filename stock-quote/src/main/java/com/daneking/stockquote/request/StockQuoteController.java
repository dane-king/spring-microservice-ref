package com.daneking.stockquote.request;

import com.daneking.stockquote.StockQuote;
import com.daneking.stockquote.scheduler.Scheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.apache.commons.lang.StringUtils.defaultIfEmpty;


@RestController
@Slf4j
public class StockQuoteController {
    private final StockQuoteClient stockQuoteClient;
    private final String fields;
    private final Scheduler scheduler;
    private final String symbols;

    public StockQuoteController(StockQuoteClient stockQuoteClient,
                                @Value("${stock.symbols:AAPL}") String symbols,
                                @Value("${stock.fields:symbol,datetime,last,vl,adp_50,adp_100,adp_200}") String fields,
                                Scheduler scheduler) {
        this.stockQuoteClient = stockQuoteClient;
        this.symbols = symbols;
        this.fields = fields;
        this.scheduler = scheduler;
    }

    @GetMapping("/quotes")
    public Flux<StockQuote> getQuotes(@RequestParam(required = false, name = "symbols") String symbols_param, @RequestParam(required = false, name = "fields") String fields_param) {
        log.info("Path is built from {} and {}", symbols_param, fields_param);
        return this.stockQuoteClient.getStockQuote(defaultIfEmpty(symbols_param,this.symbols), defaultIfEmpty(fields_param,this.fields));
    }

    @GetMapping("/test")
    public String getQuotesTest(@RequestParam(required = false, name = "symbols") String symbols_param, @RequestParam(required = false, name = "fields") String fields_param) {
        InputStream ioStream = StockQuoteController.class.getClassLoader().getResourceAsStream("response.json");
        assert ioStream != null;
        return new BufferedReader(new InputStreamReader(ioStream)).lines().collect(Collectors.joining("\n"));
    }




    @GetMapping("/market")
    public Mono<String> isMarketClosed() {
        return this.stockQuoteClient.getMarket("/market/clock.json");
    }

    @GetMapping("/send")
    public String addToQueue(){
        //scheduler.perform("F,IBM", "symbol,datetime,last,vl");
        scheduler.perform();
        return "send quotes to queue";
    }
}
