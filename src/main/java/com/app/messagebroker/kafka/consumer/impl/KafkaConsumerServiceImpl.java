package com.app.messagebroker.kafka.consumer.impl;

import com.app.messagebroker.dto.RequestMessageDto;
import com.app.messagebroker.enums.MessageBrokerEnum;
import com.app.messagebroker.exception.StringConversionException;
import com.app.messagebroker.kafka.consumer.KafkaConsumerService;
import com.app.messagebroker.model.Message;
import com.app.messagebroker.mongo.MongoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumerServiceImpl.class);

    private final MongoService mongoService;
    private final ObjectMapper objectMapper;

    public KafkaConsumerServiceImpl(MongoService mongoService,
                                    ObjectMapper objectMapper) {
        this.mongoService = mongoService;
        this.objectMapper = objectMapper;
    }


    @Override
    @KafkaListener(topics = "${kafka.topic.single-message}", groupId = "groupOne")
    public void consumeMessage(String messagePayload) {
        try {
            log.info("message payload : {}", messagePayload);
            RequestMessageDto request = objectMapper.readValue(messagePayload, RequestMessageDto.class);
            mongoService.saveMessage(composeMessage(request));
        } catch (JsonProcessingException e) {
            throw new StringConversionException(String.format("Error convert to Object : %s", e.getMessage()));
        }
    }

    private Message composeMessage(RequestMessageDto request) {
        Message message = new Message();
        message.setContent(request.content());
        message.setSender(request.sender());
        message.setMessageBrokerEnum(MessageBrokerEnum.KAFKA);

        return message;
    }
}
