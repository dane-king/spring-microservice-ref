package com.daneking.stockquote.request;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StockQuoteClient {
    private final OAuthHeader oAuthHeader;

    private final WebClient webClient;

    public StockQuoteClient(OAuthHeader oAuthHeader, @Value("${base.url}")String url, WebClient.Builder webClientBuilder){
        this.oAuthHeader = oAuthHeader;
        //set another signing method here, must be a valid signing method oAuthHeader.setSigningMethod
        this.webClient = webClientBuilder.baseUrl(url).build();
    }

    public Mono<String> getValue(String path){
        String header = oAuthHeader.generateHeader(HttpMethod.GET.name(), path);
        return webClient.get().uri(path).header(HttpHeaders.AUTHORIZATION, header).retrieve().bodyToMono(String.class);
    }

}
