package example.aop.service;

import example.aop.repository.BasicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BasicServiceImpl implements BasicService{

    private final BasicRepository repository;

    @Override
    public void save(int number) {
        log.info("BasicServiceImpl save = {}", number);
        repository.save(number);
    }
}
