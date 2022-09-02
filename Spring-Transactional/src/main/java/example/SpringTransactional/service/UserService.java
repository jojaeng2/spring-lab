package example.SpringTransactional.service;


import example.SpringTransactional.domain.Users;
import example.SpringTransactional.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void save(Users user) {
        userRepository.save(user);
    }


    @Transactional(readOnly = true)
    public Users findUsers(Long userId) {
        userRepository.findUser(userId);
        return userRepository.findUser(userId);
    }

    @Transactional
    public Users changeUserName(Long userId) {
        Users user = userRepository.findUser(userId);

        user.setName("조정현1");
        user.setName("조정현2");
        return user;
    }

    @Transactional(readOnly = true)
    public Users findUsersAndChangeName(Long userId) {
        Users user = userRepository.findUser(userId);
        user.setName("조정현3");
        return user;
    }
}
