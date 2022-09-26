package example.aop.config;

import org.aspectj.lang.annotation.Pointcut;


public class Pointcuts {

    @Pointcut("execution(* example.aop.controller..*(..))")
    public void allController() {}

    @Pointcut("execution(* example.aop.service..*(..))")
    public void allService() {}

    @Pointcut("execution(* example.aop.repository..*(..))")
    public void allRepository() {}

    @Pointcut("allController() || allService() || allRepository()")
    public void controllerAndServiceAndRepository() {}
}
