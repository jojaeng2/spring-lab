package spring.data.redis.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "people")
public class Person {


  @Id
  private String id;
  private String name;
  private Integer age;
  private LocalDateTime createdAt;

  public Person(String name, Integer age) {
    this.name = name;
    this.age = age;
    this.createdAt = LocalDateTime.now();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
