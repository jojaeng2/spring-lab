package example.async.config;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* example.async.service..*(..))")
    public void asyncService(){}

}
