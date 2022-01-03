package com.daneking.stockquote.request;

import com.daneking.stockquote.StockQuote;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Log4j2
public class StockQuoteClient {
    private final OAuthHeader oAuthHeader;

    private final WebClient webClient;

    public StockQuoteClient(OAuthHeader oAuthHeader, @Value("${base.url}")String url){
        this.oAuthHeader = oAuthHeader;
        //set another signing method here, must be a valid signing method oAuthHeader.setSigningMethod
        this.webClient = WebClient.create(url);//webClientBuilder.baseUrl(url).build();
    }

    public Mono<String> getValue(String path){
        log.info("Getting value from {}", path);
        String header = oAuthHeader.generateHeader(HttpMethod.GET.name(), path);
        return webClient
                .get()
                .uri(path)
                .header(HttpHeaders.AUTHORIZATION, header)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);

    }
    @lombok.Value
    static class StockQuoteResponse{
        List<StockQuoteHolder> quotes;
    }
    @lombok.Value
    static class StockQuoteHolder{
        String quoteType;
        StockQuote quote;
    }

}
