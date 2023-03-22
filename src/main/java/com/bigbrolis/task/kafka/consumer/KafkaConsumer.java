package com.bigbrolis.task.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumer {

    void listen(String message, ConsumerRecord<String, String> record);
}
