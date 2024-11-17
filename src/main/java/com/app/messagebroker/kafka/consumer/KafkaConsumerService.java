package com.app.messagebroker.kafka.consumer;

public interface KafkaConsumerService {

    void consumeMessage(String messagePayload);
}
