package com.consumer.marketdataconsumer.consumer;

import com.consumer.marketdataconsumer.module.MarketData;
import com.consumer.marketdataconsumer.service.MarketDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * The type Market data consumer.
 */
@Service
public class MarketDataConsumer {

    /**
     * The Market data service.
     */
    @Autowired
    MarketDataService marketDataService;
    /**
     * The constant logger.
     */
    public static Logger logger = LoggerFactory.getLogger("MarketDataConsumer");

    /**
     * Consume market data market data.
     *
     * @param message the message
     * @return the market data
     */
    @KafkaListener(topics = "marketdata", groupId = "group_id")
    public MarketData consumeMarketData(@Payload String message) {
        ObjectMapper mapper = new ObjectMapper();
        MarketData marketData = null;
        try {
            marketData = mapper.readValue(message, MarketData.class);
            marketDataService.persistMarketData(marketData);
        } catch (JsonProcessingException e) {
            logger.error("Error Occurred While Data Convertion:"+e.getLocalizedMessage());
        }
        logger.info("Received Message:"+marketData.toString());
        return marketData;
    }
}
