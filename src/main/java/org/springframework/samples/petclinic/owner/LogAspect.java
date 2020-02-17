package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// @LogExecutionTime을 실제로 구현할 Aspect
@Component
@Aspect
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(LogExecutionTime)") // @LogExecutionTime이 있는 곳에다 아래 코드를 적용하겠다
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable { // joinPoint: 타겟 메소드
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object proceed = joinPoint.proceed(); // 타겟 메소드를 실행한다

        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());

        return proceed; // 실행한 결과가 있다면 그것을 그대로 return
    }
}
