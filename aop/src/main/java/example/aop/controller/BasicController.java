package example.aop.controller;

import example.aop.service.BasicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BasicController {

    private final BasicService basicService;

    public void receiveGetMapping(int number) {
        log.info("BasicController save = {}", number);
        basicService.save(number);
    }
}
