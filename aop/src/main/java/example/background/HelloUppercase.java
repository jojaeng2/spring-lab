package example.background;

import java.util.Locale;

public class HelloUppercase implements Hello{

    private final Hello hello;

    public HelloUppercase() {
        this.hello = new HelloTarget();
    }

    @Override
    public String sayHello(String name) {
        return hello.sayHello(name).toUpperCase();
    }

    @Override
    public String sayHi(String name) {
        return hello.sayHi(name).toUpperCase();
    }

    @Override
    public String sayThankYou(String name) {
        return hello.sayThankYou(name).toUpperCase();
    }
}
