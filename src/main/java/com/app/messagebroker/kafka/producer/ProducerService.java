package com.app.messagebroker.kafka.producer;

import com.app.messagebroker.dto.RequestMessageDto;

public interface ProducerService {
    String sendSingleMessage(RequestMessageDto request);
}
