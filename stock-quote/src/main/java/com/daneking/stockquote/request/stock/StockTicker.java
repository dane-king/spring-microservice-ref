package com.daneking.stockquote.request.stock;

import lombok.Value;

@Value
class StockTicker {
    private String ticker;
    private String name;
}
