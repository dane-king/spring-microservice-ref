package com.daneking.stockquote.request;

import org.mockito.Mock;
import org.springframework.web.reactive.function.client.WebClient;

class StockQuoteClientTest {
    @Mock
    private WebClient.Builder builder;
    private OAuthHeader oAuthHeader;

}