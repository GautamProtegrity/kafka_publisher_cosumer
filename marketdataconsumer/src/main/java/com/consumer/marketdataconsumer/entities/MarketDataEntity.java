package com.consumer.marketdataconsumer.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The type Market data.
 */
@Table
@Entity
public class MarketDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private BigDecimal price;
    @Column
    private String ricCode;
    @Column
    private String lastUpdatedTime;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets ric code.
     *
     * @return the ric code
     */
    public String getRicCode() {
        return ricCode;
    }

    /**
     * Sets ric code.
     *
     * @param ricCode the ric code
     */
    public void setRicCode(String ricCode) {
        this.ricCode = ricCode;
    }

    /**
     * Gets last updated time.
     *
     * @return the last updated time
     */
    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    /**
     * Sets last updated time.
     *
     * @param lastUpdatedTime the last updated time
     */
    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

}
