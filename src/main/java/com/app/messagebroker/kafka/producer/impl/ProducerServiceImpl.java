package com.app.messagebroker.kafka.producer.impl;

import com.app.messagebroker.dto.RequestMessageDto;
import com.app.messagebroker.exception.StringConversionException;
import com.app.messagebroker.kafka.producer.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${kafka.topic.single-message}")
    private String topicSingleMessage;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerServiceImpl(ObjectMapper objectMapper,
                               KafkaTemplate<String, String> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String sendSingleMessage(RequestMessageDto request) {
        try {
            String messageString = objectMapper.writeValueAsString(request);
            log.info("message to publish : {}", messageString);
            kafkaTemplate.send(topicSingleMessage, messageString);

            return "Success publish message";
        } catch (JsonProcessingException e) {
            log.error("error when process json converting, cause : {}", e.getMessage());
            throw new StringConversionException("Error Converting to json");
        }
    }
}
