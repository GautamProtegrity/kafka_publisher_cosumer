package com.consumer.marketdataconsumer.configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Hazelcast configuration.
 */
@Configuration
public class HazelcastConfiguration {

    /**
     * Hazel cast config config.
     *
     * @return the config
     */
    @Bean
    public Config hazelCastConfig(){
        return new Config()
                .setInstanceName("hazelcast-instance")
                .addMapConfig(
                        new MapConfig()
                                .setName("marketdata")
                                .setTimeToLiveSeconds(20));
    }
}
