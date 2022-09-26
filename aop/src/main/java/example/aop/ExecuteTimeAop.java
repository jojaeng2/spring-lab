package example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class ExecuteTimeAop {

    // 패키지 내의 controller package에 존재하는 클래스
    @Before("example.aop.config.Pointcuts.controllerAndServiceAndRepository()")
    public void calculateExecutionTime(JoinPoint joinPoint){
        log.info("ExecuteTimeAop Success");
    }
}
