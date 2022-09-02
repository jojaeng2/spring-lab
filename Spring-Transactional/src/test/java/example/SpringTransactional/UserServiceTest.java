package example.SpringTransactional;

import example.SpringTransactional.domain.Users;
import example.SpringTransactional.repository.UserRepository;
import example.SpringTransactional.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @AfterEach
    public void deleteAll() {

    }

    @BeforeEach
    public void 테스트용_유저생성() {
        Users user = new Users("조정현");
        userService.save(user);
    }

    @Test
    public void 테스트유저조회성공() {
        Users user = userService.findUsers(1L);
    }

    @Test
    public void update쿼리개수확인() {
        Users user = userService.findUsers(1L);

    }

    @Test
    public void readOnly_Entity변경() {
        Users user = userService.findUsersAndChangeName(1L);

    }
}
