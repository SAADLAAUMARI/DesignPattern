package org.example.AspectsImpl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.AspectsInterface.SecuredBy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class SecurityAspect {

    private static final String CURRENT_USER_ROLE = "ROLE_USER"; // Simulé pour l'exemple

    @Around("@annotation(securedBy)")
    public Object secureMethod(ProceedingJoinPoint joinPoint, SecuredBy securedBy) throws Throwable {
        if (Arrays.asList(securedBy.roles()).contains(CURRENT_USER_ROLE)) {
            return joinPoint.proceed();
        } else {
            throw new SecurityException("Access denied: insufficient permissions.");
        }
    }
}