package example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class ExecutionTimeAop {

    // 패키지 내의 controller package에 존재하는 클래스
//    @Around("execution(* *..controller.*.*(..))")
//    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        // 해당 클래스 처지 전 시간
//        StopWatch sw = new StopWatch();
//        sw.start();
//
//        // 해당 클래스의 메소드 실행
//        Object result = joinPoint.proceed();
//
//        // 해당 클래스 처리 후의 시간
//        sw.stop();
//        long executionTime = sw.getTotalTimeMillis();
//
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        String task = className + "." + methodName;
//
//        log.info("[ExecutionTime] " + task + "-->" + executionTime + "(ms)");
//        return result;
//    }
}
