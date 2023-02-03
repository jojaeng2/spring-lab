package spring.data.redis.repository;

import org.springframework.data.repository.CrudRepository;
import spring.data.redis.entity.Person;

public interface PersonRedisRepository extends CrudRepository<Person, String> {

}
