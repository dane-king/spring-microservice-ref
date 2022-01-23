package com.daneking.stockquote;

import lombok.Data;

/**
 * Holds stock quote date to be processed later
 * use strings here for simplicity, processor will handle conversions
 */
@Data
public class StockQuote {
    private String adp_100;
    private String adp_200;
    private String adp_50;
    private String datetime;
    private String last;
    private String symbol;
    private String vl;


}
