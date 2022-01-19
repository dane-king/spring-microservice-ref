package com.daneking.stockquote.request;

import com.daneking.stockquote.StockQuote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class StockQuoteClientTest {
    private StockQuoteClient stockQuoteClient;
    @Mock
    WebClient.Builder webClientBuilder;
    @Mock
    WebClient webClient;

    @BeforeEach
    void setUp() {
//        when(webClientBuilder.baseUrl(anyString())).thenReturn(webClientBuilder);
//        when(webClientBuilder.build()).thenReturn(webClient);

        stockQuoteClient = new StockQuoteClient(
                new OAuthHeader(
                        new OAuthKeys("", "", "", "")), "base", mockWebClient());
    }

    @Test
    void shouldTransform() {
        //List<StockQuote> result = stockQuoteClient.getStockQuote("/base").block();
        String result = stockQuoteClient.getStockQuote("/base").block();
        assertThat(result).contains("response");
    }

    public WebClient mockWebClient() {
        String body = getResponse("response.json");
        System.out.println(body);
        return WebClient.builder()
                .exchangeFunction(clientRequest ->
                        Mono.just(ClientResponse.create(HttpStatus.OK)
                                .header("content-type", "application/json")
                                .body(body)
                                .build())
                ).build();
    }

    private String getResponse(String fileName){
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);
        String result = new BufferedReader(new InputStreamReader(ioStream))
                .lines().collect(Collectors.joining("\n"));
        return result;

    }


}