package com.example.JpaRepository.service;


import com.example.JpaRepository.domain.Users;
import com.example.JpaRepository.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public void save(Long id, String userName) {
        System.out.println("usersRepository = " + usersRepository);
        Users users = new Users(id, userName);
        usersRepository.save(users);
    }

    public Users find(Long id) {
        return usersRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
