package com.laaumari.ASPECTS;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoginAspect {

    Logger logger=Logger.getLogger(LoginAspect.class.getName());

    public LoginAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
//      this logger shouldn't send its output to its parent Logger
        logger.setUseParentHandlers(false);
    }

    @Pointcut("execution(* com.laaumari.METIER.IMetierBanqueImpl.*(..) ) ")
    public void pc1(){ }

    /*    @Before("pc1()")
        public void avant(JoinPoint joinPoint){
            t1=System.currentTimeMillis();
            logger.info("----------------------------------------------------");
            logger.info("Avant execution de la methode "+joinPoint.getSignature());
        }
        @After("pc1()")
        public void apres(JoinPoint joinPoint){
            logger.info("apress execution de la methode "+joinPoint.getSignature());
            t2=System.currentTimeMillis();
            logger.info("Duree d'execution de la methode :"+ (t2-t1));
            logger.info("----------------------------------------------------");
        }*/
    @Around("pc1()")
    public Object autour(ProceedingJoinPoint proceedingJoinPoint,JoinPoint joinPoint) throws Throwable {
        long t1=System.currentTimeMillis();
        logger.info("----------------------------------------------------");
        logger.info("Avant execution de la methode "+joinPoint.getSignature());
        Object resultat=proceedingJoinPoint.proceed();
        logger.info("apres execution de la methode "+joinPoint.getSignature());
        long t2=System.currentTimeMillis();
        logger.info("Duree d'execution de la methode :"+ (t2-t1));
        logger.info("----------------------------------------------------");
        return resultat;
    }
}
