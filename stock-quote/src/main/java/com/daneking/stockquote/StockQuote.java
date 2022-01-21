package com.daneking.stockquote;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class StockQuote {
    private String adp_100;
    private String adp_200;
    private String adp_50;
    private Date datetime;
    private BigDecimal last;
    private String symbol;
    private String vl;

}
