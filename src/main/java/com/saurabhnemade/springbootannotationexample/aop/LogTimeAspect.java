package com.saurabhnemade.springbootannotationexample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogTimeAspect {
    Logger logger = LoggerFactory.getLogger(LogTimeAspect.class);

    @Around("@annotation(com.saurabhnemade.springbootannotationexample.aop.LogTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed =  joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.info(joinPoint.getSignature() + " execution time :  " + executionTime + "ms");
        return proceed;
    }
}
