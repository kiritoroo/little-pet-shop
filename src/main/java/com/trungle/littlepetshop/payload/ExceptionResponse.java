package com.trungle.littlepetshop.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
public class ExceptionResponse implements Serializable {
    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    private String error;
    private String messages;
    private HttpStatus status;
    private Instant timestamp;
}
