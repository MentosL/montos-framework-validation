package org.montos.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Montos
 * @create 2021/1/26 9:51 下午
 */
@Slf4j
@Aspect
@Component
public class LogAspect {


    @Pointcut(value= "@annotation(org.montos.aop.annotation.Test)")
    public void pointCut(){
    }

    @Around(value = "pointCut()")
    public void process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("proceedingJoinPoint is start"+proceedingJoinPoint.getArgs().toString());
        proceedingJoinPoint.proceed();
        log.info("proceedingJoinPoint is end");
    }

}
