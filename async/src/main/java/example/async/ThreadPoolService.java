package example.async;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@NoArgsConstructor
@Slf4j
public class ThreadPoolService {
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void execute() {
        executorService.submit(() -> {
            for(int i=1; i<=10; i++) {
                log.info("Async i ={}", i);
            }
        });
    }
}
