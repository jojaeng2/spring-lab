package example.JPA_N1.repository;

import example.JPA_N1.domain.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LogsRepository extends JpaRepository<Logs, Integer> {

    Optional<Logs> findByUserId(Integer userId);
}
