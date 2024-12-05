package com.laaumari.ASPECTS;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LoggingAspect {
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(com.laaumari.ASPECTS.Log)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        long t1 = System.currentTimeMillis();
        logger.info("Logging Aspect ===> Before execution ");
        result = joinPoint.proceed();
        logger.info("Logging Aspect ===> After execution");
        long t2 = System.currentTimeMillis();
        logger.info("Execution Duration : " + (t2-t1));
        return result;
    }
}
