package com.daneking.stockquote.request;

import com.daneking.stockquote.StockQuote;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.format.DateTimeFormatter;

import static com.daneking.stockquote.fixture.ObjectFactory.mockWebClientBuilder;

@ExtendWith(MockitoExtension.class)
class StockQuoteClientTest {
    private StockQuoteClient stockQuoteClient;

    @BeforeEach
    void setUp() {
        stockQuoteClient = new StockQuoteClient(
                new OAuthHeader(
                        new OAuthKeys("", "", "", "")), "base", mockWebClientBuilder("response.json"));
    }

    @Test
    void shouldTransformToStockQuote() {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/uuuu'T'HH:mm:ss:SSSXXXXX");
        Flux<StockQuote> result = stockQuoteClient.getStockQuote("/base");
        StockQuote stockQuote1 = buildStockQuote("AAPL", "166.2300", "173.3105", "161.9432", "154.3666", "2022-01-19T16:00:00-05:00", "94524963");
        StockQuote stockQuote2 = buildStockQuote("IBM", "131.5800", "128.1676", "125.8475", "129.8145", "2022-01-19T00:00:00-05:00", "4100488");


        StepVerifier.create(stockQuoteClient.getStockQuote("/base"))
                .expectNext(stockQuote1)
                .expectNext(stockQuote2)
                .verifyComplete();
    }

    
    @NotNull
    private StockQuote buildStockQuote(String symbol, String last, String adp_50, String adp_100, String adp_200, String datetime, String vl) {
        StockQuote stockQuote1 = new StockQuote();
        stockQuote1.setSymbol(symbol);
        stockQuote1.setLast(last);
        stockQuote1.setAdp_50(adp_50);
        stockQuote1.setAdp_100(adp_100);
        stockQuote1.setAdp_200(adp_200);
        stockQuote1.setDatetime(datetime);
        stockQuote1.setVl(vl);
        return stockQuote1;
    }


}