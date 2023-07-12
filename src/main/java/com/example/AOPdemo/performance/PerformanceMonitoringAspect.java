package com.example.AOPdemo.performance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitoringAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    //customize annotation
    @Around("@annotation(com.example.AOPdemo.controller.PerformanceMonitor)")
    public Object measurePerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        //real data of intercepted method
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();
        String className = methodSignature.getDeclaringType().getSimpleName();

        System.out.println("Method " + methodName +" in class "+className+" took "+executionTime+" milliseconds to execute");
        LOGGER.info("Method {} in class {} took {} milliseconds to execute", methodName, className, executionTime);

        return result;
    }
}
