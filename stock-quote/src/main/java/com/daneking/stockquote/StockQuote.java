package com.daneking.stockquote;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class StockQuote {
    private String symbol;
    private BigDecimal last;
}
