package example.async;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class SyncService {

    public void execute() {
        for(int i=1; i<=10; i++) {
            log.info("Sync i = {}", i);
        }
    }
}
