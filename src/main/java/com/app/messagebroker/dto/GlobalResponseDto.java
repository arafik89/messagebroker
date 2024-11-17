package com.app.messagebroker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public record GlobalResponseDto<T>(
        T error,
        T data
) {
}
