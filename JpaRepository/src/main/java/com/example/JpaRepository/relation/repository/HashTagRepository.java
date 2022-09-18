package com.example.JpaRepository.relation.repository;

import com.example.JpaRepository.relation.domain.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagRepository extends JpaRepository<HashTag, String> {
}
