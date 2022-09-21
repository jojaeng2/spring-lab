package com.example.JpaRepository.JpaRepositoryInterface.repository;

import com.example.JpaRepository.JpaRepositoryInterface.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}

