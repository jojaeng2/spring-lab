package example.aop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BasicControllerTest {

    @Autowired
    private BasicController controller;

    @Test
    void 실행시간측정AOP적용() {
        controller.receiveGetMapping(123);
    }
}
