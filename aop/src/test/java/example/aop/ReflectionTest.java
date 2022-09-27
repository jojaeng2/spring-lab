package example.aop;

import example.background.Hello;
import example.background.HelloTarget;
import example.background.UppercaseHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ReflectionTest {


    @Test
    void methodInterfaceTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String name = "Spring";
        Method lengthMethod = String.class.getMethod("length");

        int length = (int) lengthMethod.invoke(name);
        System.out.println("length = " + length);
    }

    @Test
    void simpleProxy() {
        Hello hello = new HelloTarget();
        assertThat(hello.sayHello("Toby")).isEqualTo("Hello Toby");
        assertThat(hello.sayHi("Toby")).isEqualTo("Hi Toby");
        assertThat(hello.sayThankYou("Toby")).isEqualTo("ThankYou Toby");
    }

    @Test
    void dynamicProxy() {
        Hello proxyHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] {Hello.class},
                new UppercaseHandler(new HelloTarget())
        );
    }
}
