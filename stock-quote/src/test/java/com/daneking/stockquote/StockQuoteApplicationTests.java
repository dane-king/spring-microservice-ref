package com.daneking.stockquote;

import com.daneking.stockquote.messaging.StockMessageProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockQuoteApplicationTests {

	@Autowired
	private StockMessageProducerService kafkaMessageProducerService;

	@Test
	void contextLoads() {
		System.out.println("Just a test");
	}

}
