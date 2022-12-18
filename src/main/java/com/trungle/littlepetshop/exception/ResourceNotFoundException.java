package com.trungle.littlepetshop.exception;

import com.trungle.littlepetshop.payload.ApiResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.text.MessageFormat;

@Data
@Builder
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private transient ApiResponse apiResponse;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public void setApiResponse() {
        String message = MessageFormat.format(
            "{0} not found with {1}: {2}",
            this.resourceName,
            this.fieldName,
            this.fieldValue
        );
        this.apiResponse = ApiResponse.builder()
            .success(Boolean.FALSE)
            .message(message)
            .status(HttpStatus.NOT_FOUND)
            .build();
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }
}
