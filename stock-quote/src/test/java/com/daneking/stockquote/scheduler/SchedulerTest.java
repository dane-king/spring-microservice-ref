package com.daneking.stockquote.scheduler;

import com.daneking.stockquote.StockQuote;
import com.daneking.stockquote.messaging.StockMessageProducerService;
import com.daneking.stockquote.request.stock.StockListRepository;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.TaskScheduler;

import static com.daneking.stockquote.fixture.ObjectFactory.mockStockQuoteClient;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class SchedulerTest {


    @Test
    void shouldSendStockQuotes() {
//        QuoteTask task = mock(QuoteTask.class)
//        TaskScheduler taskScheduler = mock(TaskScheduler.class);
//        Scheduler scheduler=new Scheduler(taskScheduler, task);
//        String symbols = "F, IBM";
//        int numSymbols = StringUtils.split(symbols).length;
//        scheduler.perform(symbols, "fld");
//        verify(service, times(numSymbols)).send(any(StockQuote.class));
    }
}