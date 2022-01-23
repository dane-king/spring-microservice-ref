package com.daneking.stockquote.scheduler;

import com.daneking.stockquote.StockQuote;
import com.daneking.stockquote.messaging.StockMessageProducerService;
import org.junit.jupiter.api.Test;

import static com.daneking.stockquote.fixture.ObjectFactory.mockStockQuoteClient;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SchedulerTest {


    @Test
    void shouldSendStockQuotes() {
        StockMessageProducerService service=mock(StockMessageProducerService.class);
        Scheduler scheduler=new Scheduler(mockStockQuoteClient(), service);
        scheduler.perform("paths");
        verify(service, times(2)).send(any(StockQuote.class));
    }
}