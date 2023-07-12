package com.example.AOPdemo.exception;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DBException extends RuntimeException{
    public DBException(String message) {
        super(message);
    }
}
