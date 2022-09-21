package com.consumer.marketdataconsumer.controller;

import com.consumer.marketdataconsumer.entities.MarketDataEntity;
import com.consumer.marketdataconsumer.service.MarketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Market data consumer controller.
 */
@RestController
public class MarketDataConsumerController {

    /**
     * The Market data service.
     */
    @Autowired
    MarketDataService marketDataService;

    /**
     * Gets market data.
     *
     * @param ricCode the ric code
     * @return the market data
     */
    @GetMapping("/fetch/{ricCode}")
    public List<MarketDataEntity> getMarketData(@PathVariable("ricCode")String ricCode){
        return marketDataService.fetchMarketDataEntities(ricCode);
    }
}
