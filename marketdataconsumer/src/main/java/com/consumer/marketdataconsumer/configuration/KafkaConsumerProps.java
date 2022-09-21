package com.consumer.marketdataconsumer.configuration;

import java.util.Properties;

import com.consumer.marketdataconsumer.module.MarketData;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

/**
 * The type Kafka consumer props.
 */
@EnableKafka
@Configuration
public class KafkaConsumerProps {

	/**
	 * Factory class of consumer that returns an instance of consumer.
	 * @return the consumer factory
	 */
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {

		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, "10");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "50");

		return new DefaultKafkaConsumerFactory(props);
	}

	/**
	 * Concurrent kafka listner factory concurrent kafka listener container factory.
	 *
	 * @return the concurrent kafka listener container factory
	 */
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListnerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
