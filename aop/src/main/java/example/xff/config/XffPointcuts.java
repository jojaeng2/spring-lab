package example.xff.config;

import org.aspectj.lang.annotation.Pointcut;

public class XffPointcuts {

    @Pointcut("execution(* example.xff.service..*(..))")
    public void allService() {}
}
