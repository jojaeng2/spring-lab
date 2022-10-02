package example.xff.controller;

import example.xff.dto.Testdto;
import example.xff.service.XffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class XffController {

    private final XffService xffService;


    @GetMapping("/xff")
    public String receiveGet() {
        Testdto dto = new Testdto(1, "name");
        xffService.process(dto);
        return "ok";
    }
}
