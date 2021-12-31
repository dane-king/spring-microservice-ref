package com.daneking.stockquote.request;

import com.daneking.stockquote.StockQuote;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@Log4j2
public class StockQuoteController {
    private final StockQuoteClient stockQuoteClient;
    private String fields;
    private String symbols;

    public StockQuoteController(StockQuoteClient stockQuoteClient,
                                @Value("${stock.symbols:AAPL}") String symbols,
                                @Value("${stock.fields:symbol,datetime,last,vl,adp_50,adp_100,adp_200}") String fields) {
        this.stockQuoteClient = stockQuoteClient;
        this.symbols = symbols;
        this.fields = fields;
    }

    @GetMapping("/quotes")
    public Mono<String> getProps(@RequestParam(required = false, name = "symbols") String symbols_param, @RequestParam(required = false, name = "fields") String fields_param) {
        symbols = symbols_param == null ? symbols : symbols_param;
        fields = fields_param == null ? fields : fields_param;
        String paths = String.format("/market/ext/quotes.json?symbols=%s&fids=%s", symbols, fields);
        log.info("Path {} is built from {} and {}", paths, symbols_param, fields_param);
        return this.stockQuoteClient.getValue(paths);
    }

    @GetMapping("/market")
    public Mono<String> isMarketClosed() {
        return this.stockQuoteClient.getValue("/market/clock.json");
    }
}
