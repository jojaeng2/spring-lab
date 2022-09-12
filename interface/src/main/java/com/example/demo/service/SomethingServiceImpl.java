package com.example.demo.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Interface는 생성자를 만들 수 없기 때문에 애초에 빈으로 등록이 불가능
 * 구현체를 빈으로 등록해도 인터페이스로 상속받을 수 있는 이유는 단순하게 타입이 같기 때문
 */

@Service
@NoArgsConstructor
public class SomethingServiceImpl implements SomethingService{

}
