package com.kafka.example.app.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
public class CustomErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private List<String> errors;
    private HttpStatus status;

    public CustomErrorResponse(final HttpStatus status, final String message, LocalDateTime timestamp,
                               final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.errors = errors;
    }

    public CustomErrorResponse(final HttpStatus status, final String message, LocalDateTime timestamp,
                               final String error) {
        super();
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        errors = Arrays.asList(error);
    }
}
