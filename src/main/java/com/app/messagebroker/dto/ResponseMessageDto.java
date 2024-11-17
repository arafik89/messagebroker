package com.app.messagebroker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public record ResponseMessageDto(
        String id,
        String content,
        String sender,
        @JsonProperty("message_broker")
        String messageBroker
) {
}
