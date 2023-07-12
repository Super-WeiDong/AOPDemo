package com.example.AOPdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//use @ControllerAdvice + @ExceptionHandler to handle custom exception
@ControllerAdvice
public class DemoControllerGlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> customExceptionHandler(Exception e){
        return new ResponseEntity<String>("Catch the CustomException", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
