package com.daneking.stockquote.request;

import com.daneking.stockquote.StockQuote;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Log4j2
public class StockQuoteClient {
    private final OAuthHeader oAuthHeader;

    private final WebClient webClient;

    public StockQuoteClient(OAuthHeader oAuthHeader, @Value("${base.url}")String url, WebClient.Builder webClient){
        this.oAuthHeader = oAuthHeader;
        //set another signing method here, must be a valid signing method
        // oAuthHeader.setSigningMethod("xxxxx");
        //this.webClient = builder.baseUrl(url).build();//webClientBuilder.baseUrl(url).build();
        this.webClient=webClient.baseUrl(url).build();
    }

    public Flux<StockQuote> getStockQuote(String path){
        return getRequest(path)
                .bodyToFlux(Root.class)
                .map(Root::getResponse)
                .map(Response::getQuotes)
                .flatMapIterable(Quotes::getQuote);



    }
    public Mono<String> getMarket(String path){
        log.info("Getting value from {}", path);
        String header = oAuthHeader.generateHeader(HttpMethod.GET.name(), path);

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
