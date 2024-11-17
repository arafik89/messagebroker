package com.app.messagebroker.dto;

public record RequestMessageDto(
        String content,
        String sender
) {
}
