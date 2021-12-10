package com.daneking.stockquote.request;

import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriUtils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Modeled after stack overflow post
 * https://stackoverflow.com/a/59765764/1678926
 */



@Component
public class OAuthHeader {
    private static final Logger LOGGER = getLogger(OAuthHeader.class);
    private final String consumerKey;
    private final String consumerSecret;
    private final String token;
    private final String tokenSecret;

    //Defaults
    private static final String oauth_consumer_key = "oauth_consumer_key";
    private static final String oauth_token = "oauth_token";
    private static final String oauth_signature_method = "oauth_signature_method";
    private static final String oauth_timestamp = "oauth_timestamp";
    private static final String oauth_nonce = "oauth_nonce";
    private static final String oauth_version = "oauth_version";
    private static final String oauth_signature = "oauth_signature";

    //Defaults that can be overridden
    private String version = "1.0";
    private String signingMethod="HmacSHA256";

    public OAuthHeader(OAuthKeys keys) {
        this.consumerKey = keys.getConsumerKey();
        this.consumerSecret = keys.getConsumerSecret();
        this.token = keys.getToken();
        this.tokenSecret = keys.getTokenSecret();
    }

    public String getVersion(){
        return this.version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getSigningMethod() {
        return signingMethod;
    }

    public void setSigningMethod(String signingMethod) {
        this.signingMethod = signingMethod;
    }



    /**
     * Generates oAuth 1.0a header which can be passed as Authorization header
     *
     * @param httpMethod, ie GET, POST, etc
     * @param url, url of request
     * @return String
     */
    public String generateHeader(String httpMethod, String url)  {
        return generateHeader(httpMethod,url, Collections.emptyMap());
    }

    public String generateHeader(String httpMethod, String url, Map<String, String> requestParams){

        StringBuilder base = new StringBuilder();
        String nonce = getNonce();
        String timestamp = getTimestamp();
        String baseSignatureString = generateSignatureBaseString(httpMethod, url, requestParams, nonce, timestamp);
        String signature = null;
        signature = encryptUsingSignatureMethod(baseSignatureString);
        if(StringUtils.isBlank(signature)){
            LOGGER.error("Signature is blank");
            return "";
        }
        base.append("OAuth ");
        append(base, oauth_consumer_key, consumerKey);
        append(base, oauth_token, token);
        append(base, oauth_signature_method, this.signingMethod);
        append(base, oauth_timestamp, timestamp);
        append(base, oauth_nonce, nonce);
        append(base, oauth_version, version);
        append(base, oauth_signature, signature);
        base.deleteCharAt(base.length() - 1);
        LOGGER.info("header : {}", base);
        return base.toString();
    }

    /**
     * Generate base string to generate the oauth_signature
     *
     * @param httpMethod
     * @param url
     * @param requestParams
     * @return String
     */
    private String generateSignatureBaseString(String httpMethod, String url, Map<String, String> requestParams, String nonce, String timestamp) {
        Map<String, String> params = new HashMap<>();
        requestParams.forEach((key, value) -> put(params, key, value));
        put(params, oauth_consumer_key, consumerKey);
        put(params, oauth_nonce, nonce);
        put(params, oauth_signature_method, this.signingMethod);
        put(params, oauth_timestamp, timestamp);
        put(params, oauth_token, token);
        put(params, oauth_version, version);
        Map<String, String> sortedParams = params.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        StringBuilder base = new StringBuilder();
        sortedParams.forEach((key, value) -> base.append(key).append("=").append(value).append("&"));
        base.deleteCharAt(base.length() - 1);
        return httpMethod.toUpperCase() + "&" + encode(url) + "&" + encode(base.toString());
    }

    private String encryptUsingSignatureMethod(String input){
        String secret = encode(consumerSecret) + "&" + encode(tokenSecret);
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);

        SecretKey key = new SecretKeySpec(keyBytes, this.signingMethod);

        Mac mac;
        try {
            mac = Mac.getInstance(this.signingMethod);
            mac.init(key);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            LOGGER.error("Error encrypting : {0}", e);
            return null;
        }
        byte[] signatureBytes = mac.doFinal(input.getBytes(StandardCharsets.UTF_8));
        return new String(Base64.getEncoder().encode(signatureBytes));
    }

    private String encode(String value) {
        return UriUtils.encode(value, StandardCharsets.UTF_8);
    }

    private void put(Map<String, String> map, String key, String value) {
        map.put(encode(key), encode(value));
    }

    private void append(StringBuilder builder, String key, String value) {
        builder.append(encode(key)).append("=\"").append(encode(value)).append("\",");
    }

    private String getNonce() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        String generatedString = new Random().ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return generatedString;

    }

    private String getTimestamp() {
        return String.valueOf(Math.round((Instant.now().toEpochMilli() / 1000.0)));
    }

}
