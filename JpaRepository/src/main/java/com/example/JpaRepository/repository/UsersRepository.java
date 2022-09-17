package com.example.JpaRepository.repository;

import com.example.JpaRepository.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}

