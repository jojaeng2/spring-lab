package example.SpringTransactional.repository;

import example.SpringTransactional.domain.Users;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Users user) {
        em.persist(user);
    }

    public Users findUser(Long id) {
        return em.find(Users.class, id);
    }
}
