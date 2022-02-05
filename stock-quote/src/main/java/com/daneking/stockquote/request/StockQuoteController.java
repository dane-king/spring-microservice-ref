package com.daneking.stockquote.request;

import com.daneking.stockquote.StockQuote;
import com.daneking.stockquote.scheduler.Scheduler;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@Log4j2
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
        String paths = buildPath(symbols_param, fields_param);
        log.info("Path {} is built from {} and {}", paths, symbols_param, fields_param);
        return this.stockQuoteClient.getStockQuote(paths);
    }

    private String buildPath(String symbols_param, String fields_param) {
        return String.format("/market/ext/quotes.json?symbols=%s&fids=%s",
                symbols_param == null ? symbols : symbols_param,
                fields_param == null ? fields : fields_param);
    }

    @GetMapping("/market")
    public Mono<String> isMarketClosed() {
        return this.stockQuoteClient.getMarket("/market/clock.json");
    }

    @GetMapping("/send")
    public String addToQueue(){
        String paths = buildPath("F,IBM", "symbol,datetime,last,vl");
        log.info("Path is {}", paths);
        scheduler.perform(paths);
        return "send quotes to queue";
    }
}
