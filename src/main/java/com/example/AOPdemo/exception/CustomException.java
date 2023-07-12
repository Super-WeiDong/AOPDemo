package com.example.AOPdemo.exception;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
