package com.app.messagebroker.kafka.controller.impl;

import com.app.messagebroker.dto.GlobalResponseDto;
import com.app.messagebroker.dto.RequestMessageDto;
import com.app.messagebroker.kafka.controller.KafkaController;
import com.app.messagebroker.kafka.producer.ProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/kafka")
public class KafkaControllerImpl implements KafkaController {

    private final ProducerService producerService;

    public KafkaControllerImpl(ProducerService producerService) {
        this.producerService = producerService;
    }

    @Override
    @PostMapping("/single-message")
    public ResponseEntity<GlobalResponseDto<String>> publishSingleMessage(
            @RequestBody RequestMessageDto request
    ) {
        return new ResponseEntity<>(new GlobalResponseDto<>(null, producerService.sendSingleMessage(request)),
                HttpStatus.OK);
    }
}
