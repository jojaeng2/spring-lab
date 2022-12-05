package example.JPA_N1.repository;

import example.JPA_N1.domain.Logs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(value = true)
public class LogsRepositoryTest {

    @Autowired
    private LogsRepository logsRepository;

    private final int count = 10000;

    @BeforeEach
    void addLogs() {
        for (int i=0; i<count; i++) {
            Logs log = new Logs(i);
            logsRepository.save(log);
            System.out.println("current index" + i);
        }
    }

    @Test
    void 시간측정() throws Exception {

        long beforeTime = System.currentTimeMillis();


        Logs logs = logsRepository.findByUserId(1)
                .orElseThrow(Exception::new);

        System.out.println("logs = " + logs.getUserId());

        long afterTime = System.currentTimeMillis();
        System.out.println("시간차이(m) : " + (afterTime - beforeTime));
    }
}
