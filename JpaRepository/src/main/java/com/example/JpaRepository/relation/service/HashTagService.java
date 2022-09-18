package com.example.JpaRepository.relation.service;

import com.example.JpaRepository.relation.domain.Channel;
import com.example.JpaRepository.relation.domain.ChannelHashTag;
import com.example.JpaRepository.relation.domain.HashTag;
import com.example.JpaRepository.relation.repository.HashTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HashTagService {

    private final HashTagRepository repository;
    @Transactional(readOnly = true)
    public HashTag findById(String id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void delete(String id) {
        HashTag hashTag = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.delete(hashTag);
    }
}
