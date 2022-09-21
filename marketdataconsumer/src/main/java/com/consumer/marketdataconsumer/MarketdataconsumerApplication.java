package com.consumer.marketdataconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * The type Marketdataconsumer application.
 */
@EnableCaching
@SpringBootApplication
public class MarketdataconsumerApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(MarketdataconsumerApplication.class, args);
	}

}
