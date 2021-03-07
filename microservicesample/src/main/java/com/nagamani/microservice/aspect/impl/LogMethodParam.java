package com.nagamani.microservice.aspect.impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
@Slf4j
public class LogMethodParam {
    private static final String NAN = "NaN";

    @Before("execution(* com.nagamani.microservice.core.*.*(..))")
    private void logArgs(JoinPoint joinPoint) {
        Object[] arg = joinPoint.getArgs();
        String args = arg != null ? arg[0].toString() : NAN;
        log.debug("executing [{}] arguments are : {}", joinPoint.getSignature().getName(), args);
    }

}
