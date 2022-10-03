package example.async.config;

import example.async.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequiredArgsConstructor
public class AsyncController {
    private final AsyncService asyncService;

    @GetMapping("/async")
    public String getAsync() {
        for(int i=1; i<=5; i++) {
            asyncService.execute(i);
        }
        return "ok";
    }

    @GetMapping("/async2")
    public String getAsync2() throws ExecutionException, InterruptedException {
        Future<String> future = asyncService.executeWithString(1);
        while(true) {
            if(future.isDone()) {
                System.out.println("Result from process = " + future.get());
                break;
            }
        }


        return "ok";
    }
}
