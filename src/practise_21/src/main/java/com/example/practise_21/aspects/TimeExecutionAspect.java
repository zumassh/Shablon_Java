package com.example.practise_21.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TimeExecutionAspect {
    private static final Logger log = LoggerFactory.getLogger(TimeExecutionAspect.class);

    @Around("execution(* com.example.practise_20.Service.*.*(..))")
    public Object TimeExecutionMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("{} executed in {} ms", joinPoint.getSignature(), endTime - startTime);
        return proceed;
    }
}