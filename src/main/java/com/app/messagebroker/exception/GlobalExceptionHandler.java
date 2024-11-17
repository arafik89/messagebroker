package com.app.messagebroker.exception;

import com.app.messagebroker.dto.GlobalResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StringConversionException.class)
    public ResponseEntity<GlobalResponseDto<String>> handlerStringConversion(StringConversionException e) {
        return new ResponseEntity<>(new GlobalResponseDto<>(e.getMessage(), null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<GlobalResponseDto<String>> handlerJsonProcessing(JsonProcessingException e) {
        return new ResponseEntity<>(new GlobalResponseDto<>(e.getMessage(), null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
