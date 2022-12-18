package com.trungle.littlepetshop.exception;

import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.ExceptionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resolveException(ResourceNotFoundException exception) {
        exception.setApiResponse();
        ApiResponse response = exception.getApiResponse();

        return new ResponseEntity<>(
            response,
            HttpStatus.NOT_FOUND
        );
    }

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> resolveException(DataIntegrityViolationException exception) {
        ExceptionResponse response = ExceptionResponse.builder()
            .error(HttpStatus.CONFLICT.getReasonPhrase())
            .messages(exception.getMessage())
            .status(HttpStatus.CONFLICT)
            .timestamp(Instant.now())
            .build();

        return new ResponseEntity<>(
            response,
            HttpStatus.CONFLICT
        );
    }
}
