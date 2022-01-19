package com.daneking.stockquote.request;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

class StockQuoteClientIT {
//    public static MockWebServer mockBackEnd;
//    private StockQuoteClient client;
//    private String body;
//
//    @BeforeAll
//    static void setUp() throws IOException {
//        mockBackEnd = new MockWebServer();
//        mockBackEnd.start();
//    }
//
//    @BeforeEach
//    void initialize() {
//        String baseUrl = String.format("http://localhost:%s",
//                mockBackEnd.getPort());
//        body=sampleResponse;
//        client = new StockQuoteClient(buildOAuthHeader(), baseUrl, WebClient.builder());
//    }
//
//    @Test
//    void getStockQuotes() throws Exception {
//        mockBackEnd.enqueue(new MockResponse()
//                .setBody(body)
//                .addHeader("Content-Type", "application/json")
//                .addHeader(HttpHeaders.AUTHORIZATION, buildOAuthHeader()));
//
//        Mono<String> response = client.getStockQuote("/quotes");
//
//        StepVerifier.create(response)
//                .expectNextMatches(r -> r.equals(response))
//                .verifyComplete();
//    }
//
//    private OAuthHeader buildOAuthHeader() {
//        String version = "1.2";
//        OAuthKeys keys = new OAuthKeys("ck", "cs", "tk", "tks");
//        OAuthHeader header = new OAuthHeader(keys);
//        header.setVersion(version);
//        return header;
//    }
//
//    @AfterAll
//    static void tearDown() throws IOException {
//        mockBackEnd.shutdown();
//    }
//    //private static final String sampleResponse="{\"response\":\"\"}";
//    private static final String sampleResponse = "{\"response\":{\"@id\":\"c5f33cbc-3638-4a98-824c-2ad7c55a0c7b\",\"elapsedtime\":\"0\",\"quotes\":{\"quotetype\":\"Real Time - market data real time, National Best Bid and Offer\",\"quote\":{\"adp_100\":\"155.9034\",\"adp_200\":\"150.4169\",\"adp_50\":\"166.1117\",\"adv_21\":\"112025203\",\"adv_30\":\"118740793\",\"adv_90\":\"89876768\",\"ask\":\"179.9000\",\"ask_time\":\"07:34\",\"asksz\":\"45\",\"basis\":\"na\",\"beta\":\"0.7282\",\"bid\":\"179.8700\",\"bid_time\":\"07:34\",\"bidsz\":\"2\",\"bidtick\":\"d\",\"chg\":\"0.0000\",\"chg_sign\":\"e\",\"chg_t\":\"na\",\"cl\":\"179.3800\",\"contract_size\":\"na\",\"cusip\":\"na\",\"date\":\"2021-12-29\",\"datetime\":\"2021-12-29T00:00:00-05:00\",\"days_to_expiration\":\"na\",\"div\":\"0.22\",\"divexdate\":\"20211105\",\"divfreq\":\"Q\",\"divpaydt\":\"20211111\",\"dollar_value\":\"24530143.26\",\"eps\":\"5.61\",\"exch\":\"NASD\",\"exch_desc\":\"NASDAQ\",\"hi\":\"0.0000\",\"iad\":\"0.88\",\"idelta\":\"na\",\"igamma\":\"na\",\"imp_volatility\":\"na\",\"incr_vl\":\"3669648\",\"irho\":\"na\",\"issue_desc\":\"na\",\"itheta\":\"na\",\"ivega\":\"na\",\"last\":\"179.3800\",\"lo\":\"0.0000\",\"name\":\"APPLE INC.\",\"op_delivery\":\"na\",\"op_flag\":\"1\",\"op_style\":\"na\",\"op_subclass\":\"na\",\"openinterest\":\"na\",\"opn\":\"0.0000\",\"opt_val\":\"na\",\"pchg\":\"0.00\",\"pchg_sign\":\"e\",\"pcls\":\"179.3800\",\"pe\":\"0.00\",\"phi\":\"180.6300\",\"plo\":\"178.14\",\"popn\":\"179.3300\",\"pr_adp_100\":\"155.3828\",\"pr_adp_200\":\"150.2071\",\"pr_adp_50\":\"165.2714\",\"pr_date\":\"2021-12-29\",\"pr_openinterest\":\"na\",\"prbook\":\"46.7100\",\"prchg\":\"0.05\",\"prem_mult\":\"na\",\"put_call\":\"na\",\"pvol\":\"62348931\",\"qcond\":\"0\",\"rootsymbol\":\"na\",\"secclass\":\"0\",\"sesn\":\"na\",\"sho\":\"16406397000\",\"strikeprice\":\"na\",\"symbol\":\"AAPL\",\"tcond\":\"29\",\"timestamp\":\"1640840400\",\"tr_num\":\"3589\",\"tradetick\":\"e\",\"trend\":\"na\",\"under_cusip\":\"na\",\"undersymbol\":\"na\",\"vl\":\"136458\",\"volatility12\":\"0.2511\",\"vwap\":\"179.76\",\"wk52hi\":\"182.13\",\"wk52hidate\":\"20211213\",\"wk52lo\":\"116.21\",\"wk52lodate\":\"20210308\",\"xdate\":\"na\",\"xday\":\"na\",\"xmonth\":\"na\",\"xyear\":\"na\",\"yield\":\"0.49058\"}},\"error\":\"Success\"}}";
}