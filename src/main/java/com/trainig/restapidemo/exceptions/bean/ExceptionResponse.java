package com.trainig.restapidemo.exceptions.bean;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private LocalDateTime timestamp;
    private String message;
    private Object details;

    public ExceptionResponse(LocalDateTime timestamp, String message, Object details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Object getDetails() {
        return details;
    }
}
