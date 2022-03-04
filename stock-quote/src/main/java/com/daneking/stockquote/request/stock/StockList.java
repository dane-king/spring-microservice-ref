package com.daneking.stockquote.request.stock;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document(collection= "stock_list")
public class StockList {

    private final String name;
    private final String owner;


    private List<StockTicker> stocks = new ArrayList<>();

    public StockList(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public List<StockTicker> getStocks() {
        return Collections.unmodifiableList(stocks);
    }

    public void setStocks(List<StockTicker> stocks) {
        this.stocks = stocks;
    }

    public void addStock(StockTicker stockTicker) {
        this.stocks.add(stockTicker);
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }
}
