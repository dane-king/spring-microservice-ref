package com.daneking.stockquote.request.stock;

import lombok.Value;

@Value
public
class StockTicker {
    private String symbol;
    private String name;
}
