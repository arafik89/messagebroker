package com.app.messagebroker.kafka.controller;

import com.app.messagebroker.dto.GlobalResponseDto;
import com.app.messagebroker.dto.RequestMessageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Kafka", description = "This endpoint for publish message with kafka.")
public interface KafkaController {

    @Operation(
            summary = "Publish single message",
            description = "This for publish message to kafka with topic kafka-single-message"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully published")
    })
    ResponseEntity<GlobalResponseDto<String>> publishSingleMessage(@RequestBody RequestMessageDto request);
}
