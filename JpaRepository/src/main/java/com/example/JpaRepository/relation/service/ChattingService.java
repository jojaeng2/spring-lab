package com.example.JpaRepository.relation.service;

import com.example.JpaRepository.relation.domain.ChatLog;
import com.example.JpaRepository.relation.repository.ChattingLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChattingService {

    private final int pagingSize = 20;
    private final ChattingLogRepository repository;

    @Transactional
    public void save(ChatLog chatLog) {
        repository.save(chatLog);
    }

    @Transactional(readOnly = true)
    public List<ChatLog> findChatLog(int page) {
        return repository.findChatLog(PageRequest.of(page, pagingSize))
                .stream().collect(Collectors.toList());
    }
}
