package com.consumer.marketdataconsumer.repositories;

import com.consumer.marketdataconsumer.entities.MarketDataEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Market data repository.
 */
@Repository
public interface MarketDataRepository extends CrudRepository<MarketDataEntity, Integer> {


    /**
     * Find by ric code list.
     *
     * @param ricCode the ric code
     * @return the list
     */
    @Query("SELECT a FROM MarketDataEntity a WHERE a.ricCode=:ricCode")
    List<MarketDataEntity> findByRicCode(String ricCode);
}
