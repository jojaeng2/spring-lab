package example.async.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
@NoArgsConstructor
public class AsyncService {

    public void execute() {
        log.info("AsyncService execute()");
    }

    @Async
    public Future<String> executeWithString(int i) {
        return new AsyncResult<>("hello world " + i + "!!!\n");
    }
}
