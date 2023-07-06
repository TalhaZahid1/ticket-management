package com.personal.practice.exception;

import com.personal.practice.exception.pojo.ErrorDetails;
import com.personal.practice.exception.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setDetails(ex.getMessage());
        errorDetails.setDeveloperMessage(ex.getClass().getName());
        errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetails.setTitle("Resource not found");
        errorDetails.setTimestamp(new Date().getTime());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
