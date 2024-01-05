package com.daneking.stockquote.request.stock;

import com.daneking.stockquote.request.stock.model.StockList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

//TODO circuit breaker
@Service
@Slf4j
@Lazy
public class StockListService {
    private final StockListRepository repository;

    public StockListService(StockListRepository repository) {
        this.repository = repository;
    }
    @Retryable
    public List<StockList> getStockListsFor(String owner) {
        return repository.findByOwner(owner);
    }

    @Recover
    public List<StockList> recoverList(RuntimeException exception){
        log.error("Sending a empty list", exception);
        return Collections.emptyList();
    }
    public StockList getStockListFor(String owner, String name) {
        return repository.findByOwnerAndName(owner, name);
    }

    public List<StockList> getAllStockLists() {
        return repository.findAll();
    }

    public StockList save(StockList stockList) {
        return null;
    }
}
