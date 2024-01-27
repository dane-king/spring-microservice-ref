package com.daneking.stockquote.request;

import com.daneking.stockquote.StockQuote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@Lazy
public class StockQuoteClient {
    //TODO make @Value
    public static final String QUOTE_PATH = "/market/ext/quotes.json?symbols=%s&fids=%s";
    private final OAuthHeader oAuthHeader;

    private final WebClient webClient;

    /**
     * set another signing method here, must be a valid signing method
     * oAuthHeader.setSigningMethod("xxxxx");
     * @param oAuthHeader wrapper for OAuth logic
     * @param url base url
     * @param webClient webclient to make request
     */
    public StockQuoteClient(OAuthHeader oAuthHeader, @Value("${base.url:}") String url, WebClient.Builder webClient) {
        this.oAuthHeader = oAuthHeader;
        this.webClient = webClient.baseUrl(url).build();
    }

    public Flux<StockQuote> getStockQuote(String symbols, String fields) {
        return getStockQuote(buildPath(symbols, fields));
    }


    private String buildPath(String symbols_param, String fields_param) {
        return String.format(QUOTE_PATH,
                symbols_param,
                fields_param);
    }

    public Flux<StockQuote> getStockQuote(String path) {
        return getRequest(path)
                .bodyToFlux(Root.class)
                .map(Root::getResponse)
                .map(Response::getQuotes)
                .flatMapIterable(Quotes::getQuote)
                .doOnError(error -> log.error("Error fetching stock quotes:", error))
                .onErrorReturn(fallbackValue());
    }

    private StockQuote fallbackValue() {
        StockQuote fallBack = new StockQuote();
        fallBack.setSymbol("XXXXX");
        fallBack.setLast("-0.01");
        return fallBack;
    }

    public Mono<String> getMarket(String path) {
        log.info("Getting value from {}", path);
        return getRequest(path)
                .bodyToMono(String.class);
    }

    private WebClient.ResponseSpec getRequest(String path) {
        log.info("Getting value from {}", path);
        String header = oAuthHeader.generateHeader(HttpMethod.GET.name(), path);
        return webClient
                .get()
                .uri(path)
                .header(HttpHeaders.AUTHORIZATION, header)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }


}
