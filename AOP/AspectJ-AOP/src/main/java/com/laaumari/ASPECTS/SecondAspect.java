package com.laaumari.ASPECTS;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SecondAspect {
    @Pointcut("execution(* com.laaumari.TEST.Main.main(..))")
    public void pc1(){}

//    @Before("pc1()")
//    public void beforeMain() {
//        System.out.println("--------------------------------");
//        System.out.println("Before main from Aspect2 with AspectJ syntax");
//        System.out.println("--------------------------------");
//    }
//    @After("pc1()")
//    public void afterMain(){
//        System.out.println("--------------------------------");
//        System.out.println("After main from Aspect2 with AspectJ syntax");
//        System.out.println("--------------------------------");
//    }
    @Around("pc1()")
    public void aroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("--------------------------------");
        System.out.println("Before main from Aspect2 with AspectJ syntax");
        System.out.println("--------------------------------");
        proceedingJoinPoint.proceed();
        System.out.println("--------------------------------");
        System.out.println("After main from Aspect2 with AspectJ syntax");
        System.out.println("--------------------------------");
    }
}
