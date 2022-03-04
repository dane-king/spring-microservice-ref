package com.daneking.stockquote.request.stock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

//Make controllers dev only
@RestController
@Slf4j
public class StockListsController {
    private final StockListRepository repository;

    public StockListsController(StockListRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/holdings")
    public List<StockList> getAllListings(){
        return repository.findAll();
    }
    @GetMapping("/holdings/{owner}")
    public List<StockList> getAllListingsByName(@PathVariable String owner,
                                                @RequestParam(required = false) String name){
        log.info("Retrieving holding by owner: {} name: {}", owner, name);
        if(StringUtils.isEmpty(name)) return repository.findByOwner(owner);
        return Collections.singletonList(repository.findByOwnerAndName(owner,name));
    }

    @PostMapping("/holdings")
    public StockList addStockTicker(@RequestBody StockTicker stockTicker,
                                    @RequestParam(required = false) String owner,
                                    @RequestParam(required = false) String name){
        log.info("Saving {}", stockTicker);
        String listName = StringUtils.defaultString(name, "watched");
        String listOwner = StringUtils.defaultString(owner, "kingd9");
        StockList stockList=new StockList(listName,listOwner);
        stockList.addStock(stockTicker);
        return repository.save(stockList);
    }
}
