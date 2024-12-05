package com.laaumari.ASPECTS;

import com.laaumari.SERVICES.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class SecurityAspect {

    @Around(value = "@annotation(securedByAspect)", argNames =
            "proceedingJoinPoint,securedByAspect")
    public Object log(ProceedingJoinPoint proceedingJoinPoint, SecuredByAspect
            securedByAspect) throws Throwable {
        String[] roles = securedByAspect.roles();
        boolean authorized = false;
        for (String r : roles) { //pour comparer les rôles d'accès à la méthode avec ceux qui sont fournis.
            if (SecurityContext.hasRole(r)) {
                authorized = true;
                break;
            }
        }
        if (!authorized) {
            throw new RuntimeException("Not Authorized");
        } else {
            return proceedingJoinPoint.proceed();
        }
    }
}
