package com.example.JpaRepository;

import com.example.JpaRepository.JpaRepositoryInterface.domain.Users;
import com.example.JpaRepository.JpaRepositoryInterface.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersServiceTest {

    @Autowired
    private UsersService usersService;



    @Test
    void 회원저장테스트_성공() {
        // given
        Long id = 1L;
        String userName = "정현조";

        // when
        usersService.save(id, userName);
        Users findUser = usersService.find(id);

        // then
        System.out.println("findUser = " + findUser.getUserName());
    }
}
