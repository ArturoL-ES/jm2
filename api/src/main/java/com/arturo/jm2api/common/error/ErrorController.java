package com.arturo.jm2api.common.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Error> error(RuntimeException exception) {
        
        if (exception instanceof CustomException) {
            CustomException customException = (CustomException) exception;
            Error error = new Error();
            
            error.setCode(customException.getStatus().value());
            error.setMessage(customException.getMessage());
            error.setTimestamp(System.currentTimeMillis());
            
            return new ResponseEntity<>(error, customException.getStatus());
        }
        
        return new ResponseEntity<>(Error.errorGeneric(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
