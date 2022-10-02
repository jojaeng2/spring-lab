package example.xff.service;

import example.xff.dto.Testdto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class XffService {

    public void process(Testdto dto) {
        System.out.println("Hello!@#");
    }
}
