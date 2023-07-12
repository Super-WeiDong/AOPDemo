package com.example.AOPdemo.controller;

import com.example.AOPdemo.exception.CustomException;
import com.example.AOPdemo.exception.DBException;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/aop")
public class DemoController {

    //exception handling AOP demo
    @GetMapping("/m1")
    public ResponseEntity<String> getMessage(){
        throw new CustomException("Custom exception occurred!");
    }

    //logging AOP demo
    @GetMapping("/m2")
    public ResponseEntity<String> getResponse(){
        return new ResponseEntity<>("Hello World",HttpStatus.OK);
    }

    //Security management AOP
    @GetMapping("/m3")
    public ResponseEntity<String> getResult(){
        return new ResponseEntity<>("Here we go",HttpStatus.OK);
    }

    //performance AOP
    @PerformanceMonitor
    @GetMapping("/m4")
    public ResponseEntity<String> getStrong(){
        return new ResponseEntity<>("CR7!",HttpStatus.OK);
    }
    @CacheHandler
    @GetMapping("/m5")
    public ResponseEntity<String> getCache(){
        return new ResponseEntity<>("cache data!",HttpStatus.OK);
    }
}
