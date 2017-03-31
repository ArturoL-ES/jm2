package com.arturo.jm2api.common.error;

import org.springframework.http.HttpStatus;

public class Error {
    
    private Integer code;
    private String message;
    private Long timestamp;
    
    public Error() { }
    
    public static Error errorGeneric() {
        Error error = new Error();
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        // TODO set message.
        error.setMessage("ErrorMessage.GENERIC");
        error.setTimestamp(System.currentTimeMillis());
        return error;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getErrorMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Long getTimestamp() {
        return timestamp;    
    }
    
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;    
    }
    
}
