package org.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

/**Аспект для логирования вызовов методов*/
@Aspect
public class LoggingAspect {
    private static final Log log = LogFactory.getLog(LoggingAspect.class);

    /**Pointcut для всех методов*/
    @Around("execution(* *())")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] methodArgs = joinPoint.getArgs();

        // Логирование вызова метода с параметрами
        System.out.println("вызываемый метод: " + methodName + " с параметрами: " + Arrays.toString(methodArgs));
        Object result = null;
        try {
            // Логирование метода
            result = joinPoint.proceed();

            // Логирование возвращаемого значения
            System.out.println("метод " + methodName + " результат: " + result);
        } catch (Throwable ex) {
            // Логирование исключения
            System.out.println("метод " + methodName + " выбрасываемое исключение: " + ex);
            throw ex;
        }

        return result;
    }
}
