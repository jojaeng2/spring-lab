package example.aop;

import example.background.Hello;
import example.background.HelloTarget;
import example.background.UppercaseAdvice;
import example.background.UppercaseHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
public class ReflectionTest {


//    @Test
//    void methodInterfaceTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        String name = "Spring";
//        Method lengthMethod = String.class.getMethod("length");
//
//        int length = (int) lengthMethod.invoke(name);
//        System.out.println("length = " + length);
//    }
//
//    @Test
//    void simpleProxy() {
//        Hello hello = new HelloTarget();
//        assertThat(hello.sayHello("Toby")).isEqualTo("Hello Toby");
//        assertThat(hello.sayHi("Toby")).isEqualTo("Hi Toby");
//        assertThat(hello.sayThankYou("Toby")).isEqualTo("ThankYou Toby");
//    }
//
//    @Test
//    void dynamicProxy() {
//        Hello proxyHello = (Hello) Proxy.newProxyInstance(
//                getClass().getClassLoader(),
//                new Class[] {Hello.class},
//                new UppercaseHandler(new HelloTarget())
//        );
//    }
//
//    @Test
//    void proxyFactoryBean() {
//        ProxyFactoryBean pfBean = new ProxyFactoryBean();
//        pfBean.setTarget(new HelloTarget());     // 타깃 설정
//        pfBean.addAdvice(new UppercaseAdvice()); // 부가기능을 담은 어드바이스를 추가한다. 어드바이스는 여러 개가 추가될 수도 있다.
//
//        Hello proxyHello = (Hello) pfBean.getObject(); // getObject()로 생성된 프록시를 가져온다.
//    }
//
//    @Test
//    void pointcutAdvisor() {
//        ProxyFactoryBean pfBean = new ProxyFactoryBean();
//        pfBean.setTarget(new HelloTarget());
//
//        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
//        pointcut.setMappedNames("sayH*");
//
//        pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
//
//        Hello proxyHello = (Hello) pfBean.getObject();
//
//        System.out.println(proxyHello.sayHello("Toby"));
//        System.out.println(proxyHello.sayHi("Toby"));
//        System.out.println(proxyHello.sayThankYou("Toby"));
//    }
}
