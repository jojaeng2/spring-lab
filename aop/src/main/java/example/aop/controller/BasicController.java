package example.aop.controller;

import org.springframework.stereotype.Controller;

@Controller
public class BasicController {

    public void receiveGetMapping(int number) {
        System.out.println("number = " + number);
    }
}
