package com.fi.stc.leavesms.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {
  
  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<ErrorMessage> resourceNotFoundException(Exception ex) {
    ErrorMessage message = new ErrorMessage(
        new Date(),
        ex.getMessage());
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
  }
}