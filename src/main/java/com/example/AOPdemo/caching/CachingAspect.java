package com.example.AOPdemo.caching;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class CachingAspect {
    private static final Map<String, Object> CACHE = new HashMap<>();

    @Around("@annotation(com.example.AOPdemo.controller.CacheHandler)")
    public Object cacheMethodResult(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();

        // Check if the result is already cached
        if (CACHE.containsKey(methodName)) {
            System.out.println("return from cache");
            return CACHE.get(methodName);
        }

        // If not cached, proceed with the method execution
        Object result = joinPoint.proceed();

        // Cache the method result
        CACHE.put(methodName, result);
        System.out.println("put data into cache");

        return result;
    }

    public static void clearCache() {
        CACHE.clear();
    }
}
