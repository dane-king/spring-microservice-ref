package com.daneking.stockquote.request;

import com.daneking.stockquote.StockQuote;
import lombok.Data;

import java.util.List;

@Data
class Quotes {
    private List<StockQuote> quote;

}
