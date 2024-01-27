package com.daneking.stockquote.request;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OAuthKeys {
    private final String consumerKey;
    private final String consumerSecret;
    private final String token;
    private final String tokenSecret;

    public OAuthKeys(
            @Value("${client.key:}") String consumerKey,
            @Value("${client.secret:}") String consumerSecret,
            @Value("${oauth.token:}") String token,
            @Value("${oauth.secret:}") String tokenSecret) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.token = token;
        this.tokenSecret = tokenSecret;
    }


    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getToken() {
        return token;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }
}
