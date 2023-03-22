package com.bigbrolis.task.kafka.consumer.impl;

import com.bigbrolis.task.kafka.consumer.KafkaConsumer;
import com.bigbrolis.task.service.WeatherDataService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerImpl implements KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerImpl.class);

    private final WeatherDataService weatherDataService;

    @Autowired
    public KafkaConsumerImpl(final WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @Override
    @KafkaListener(id = "${kafka.group.id}", topics = "${kafka.topic.name}")
    public void listen(@Payload final String message, final ConsumerRecord<String, String> record) {
        logger.debug("Message Received...");
        logger.debug("Key: {}", record.key());
        logger.debug("Partition: {}", record.partition());
        logger.debug("Offset: {}", record.offset());
        logger.debug("Timestamp: {}", record.timestamp());
        logger.debug("Message: {}", message);
        weatherDataService.saveWeatherData(message);
    }
}
