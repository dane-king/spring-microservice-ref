package com.daneking.stockquote.request.stock;

import com.daneking.stockquote.request.stock.model.StockList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO: integration test

@Repository
public interface StockListRepository extends MongoRepository<StockList,Long> {
    List<StockList> findByOwner(String owner);
    StockList findByOwnerAndName(String owner, String name);
}
