package com.example.AOPdemo.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component // Add this annotation to make it a Spring bean
public class LoggingAspect {

    @Pointcut("execution(public org.springframework.http.ResponseEntity<String> com.example.AOPdemo.controller.DemoController.getResponse(..))")
    public void getResponsePointcut() {
        // Empty method as a placeholder for the pointcut expression
    }

    @Before("getResponsePointcut()")
    public void doSomethingBefore() {
        System.out.println("Doing something before getResponse()");
    }

    @After("getResponsePointcut()")
    public void doSomethingAfter() {
        System.out.println("Doing something after getResponse()");
    }
}
