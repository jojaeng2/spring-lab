package com.example.JpaRepository.relation.service;


import com.example.JpaRepository.relation.domain.ChannelHashTag;
import com.example.JpaRepository.relation.domain.HashTag;
import com.example.JpaRepository.relation.repository.ChannelHashTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChannelHashTagService {

    private final ChannelHashTagRepository repository;

    @Transactional(readOnly = true)
    public ChannelHashTag findById(String id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
