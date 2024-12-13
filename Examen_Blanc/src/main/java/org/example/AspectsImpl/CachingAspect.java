package org.example.AspectsImpl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.example.AspectsInterface.Cachable; // Import correct

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CachingAspect {
    private final Map<String, Object> cache = new HashMap<>();

    @Around("@annotation(org.example.AspectsInterface.Cachable)")
    public Object cacheResult(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        if (cache.containsKey(key)) {
            System.out.println("Cache hit for " + key);
            return cache.get(key);
        }
        Object result = joinPoint.proceed();
        cache.put(key, result);
        System.out.println("Cache stored for " + key);
        return result;
    }
}
