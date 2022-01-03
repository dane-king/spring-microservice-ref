package com.daneking.stockquote.request;


import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;


public class OAuthHeaderTest {
   private String headerRegex ="^OAuth oauth_consumer_key=\"%s\",oauth_token=\"%s\",oauth_signature_method=\"%s\",oauth_timestamp=\"\\d{10}\",oauth_nonce=\".+\",oauth_version=\"%s\",oauth_signature=\".+\"$";

   @Test
   public void shouldRequestHeader() {
       String version = "1.2";
       OAuthKeys keys=new OAuthKeys("ck", "cs", "tk", "tks");
       OAuthHeader header = new OAuthHeader(keys);
       header.setVersion(version);

       String headerRegexPattern = String.format(headerRegex, "ck", "tk","HmacSHA256", version);
       Pattern pattern = Pattern.compile(headerRegexPattern);

       String requestHeader = header.generateHeader("method", "url", Map.of("a", "b"));
       assertThat(requestHeader, matchesPattern(pattern));
   }

    @Test
    public void shouldRequestHeaderDefaultSignatureAndVersion() throws NoSuchAlgorithmException {
        String consumerKey = "ck";
        String token = "tk";

        OAuthKeys keys=new OAuthKeys(consumerKey, "cs", token, "tks");
        OAuthHeader header = new OAuthHeader(keys);

        String requestHeader = header.generateHeader("method", "url", Map.of("a", "b"));

        String headerRegexPattern = String.format(headerRegex, consumerKey, token, "HmacSHA256", "1.0");
        Pattern pattern = Pattern.compile(headerRegex);
        assertThat(requestHeader, matchesPattern(headerRegexPattern));
    }


}