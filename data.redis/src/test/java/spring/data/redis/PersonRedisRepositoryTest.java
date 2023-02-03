package spring.data.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.data.redis.entity.Person;
import spring.data.redis.repository.PersonRedisRepository;

@SpringBootTest
public class PersonRedisRepositoryTest {
  @Autowired
  private PersonRedisRepository repo;

  @Test
  void test() {
    Person person = new Person("Park", 20);

    // 저장
    repo.save(person);

    // `keyspace:id` 값을 가져옴
    repo.findById(person.getId());

    // Person Entity 의 @RedisHash 에 정의되어 있는 keyspace (people) 에 속한 키의 갯수를 구함
    long count = repo.count();
    System.out.println("count = " + count);

    // 삭제
  }

}
