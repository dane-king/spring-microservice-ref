package com.daneking.stockquote.fixture;

import com.daneking.stockquote.request.OAuthHeader;
import com.daneking.stockquote.request.OAuthKeys;
import com.daneking.stockquote.request.StockQuoteClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ObjectFactory {

    public static StockQuoteClient mockStockQuoteClient() {
        return new StockQuoteClient(new OAuthHeader(new OAuthKeys("", "", "", "")), "base", mockWebClientBuilder("response.json"));
    }


    public static WebClient.Builder mockWebClientBuilder(String filePath) {
        String body = getResponse(filePath);
        return WebClient.builder().exchangeFunction(clientRequest -> Mono.just(ClientResponse.create(HttpStatus.OK).header("content-type", "application/json").body(body).build()));
    }

    /**
     * @param fileName of response in resource directory
     * @return response as a string
     */
    public static String getResponse(String fileName) {
        InputStream ioStream = ObjectFactory.class.getClassLoader().getResourceAsStream(fileName);
        assert ioStream != null;
        return new BufferedReader(new InputStreamReader(ioStream)).lines().collect(Collectors.joining("\n"));

    }
}
