package com.arturo.common.error;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private HttpStatus status;
    private String message;
    
    public CustomException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }
    
    public HttpStatus getStatus() {
        return status;    
    }
    
    public String getMessage() {
        return message;    
    }
    
}
