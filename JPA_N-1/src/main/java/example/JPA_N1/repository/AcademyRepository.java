package example.JPA_N1.repository;

import example.JPA_N1.domain.Academy;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AcademyRepository extends JpaRepository<Academy, Long> {

    /**
     * 1. join fetch를 통한 조회
     */
    @Query("select a from Academy a join fetch a.subjects")
    List<Academy> findAllJoinFetch();

    /**
     * 2. @EntityGraph
     */
    @EntityGraph(attributePaths = "subjects")
    @Query("select a from Academy a")
    List<Academy> findAllEntityGraph();

    /**
     * 5. Academy + Subject + Teacher를 Join fetch로 조회
     */
    @Query("select a from Academy a join fetch a.subjects s join fetch s.teacher")
    List<Academy> findAllWithTeacher();
}
