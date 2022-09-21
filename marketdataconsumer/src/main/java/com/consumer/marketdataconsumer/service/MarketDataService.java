package com.consumer.marketdataconsumer.service;

import com.consumer.marketdataconsumer.entities.MarketDataEntity;
import com.consumer.marketdataconsumer.module.MarketData;
import com.consumer.marketdataconsumer.repositories.MarketDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Market data service.
 */
@Service
public class MarketDataService {

    /**
     * The Market data repository.
     */
    @Autowired
    MarketDataRepository marketDataRepository;

    /**
     * Persist market data.
     *
     * @param marketData the market data
     */
    @Async
    public void persistMarketData(MarketData marketData){

        MarketDataEntity marketDataEntity = new MarketDataEntity();
        marketDataEntity.setPrice(marketData.getPrice());
        marketDataEntity.setRicCode(marketData.getRicCode());
        marketDataEntity.setLastUpdatedTime(marketData.getLastUpdatedTime());
        marketDataRepository.save(marketDataEntity);
    }

    /**
     * Fetch market data entities list.
     *
     * @param ricCode the ric code
     * @return the list
     */
    public List<MarketDataEntity> fetchMarketDataEntities(String ricCode){

        return marketDataRepository.findByRicCode(ricCode);
    }
}
