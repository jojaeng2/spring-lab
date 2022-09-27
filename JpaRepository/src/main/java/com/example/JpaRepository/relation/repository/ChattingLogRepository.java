package com.example.JpaRepository.relation.repository;

import com.example.JpaRepository.relation.domain.ChatLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChattingLogRepository extends JpaRepository<ChatLog, String> {

    @Query("select c from ChatLog c")
    Slice<ChatLog> findChatLog(Pageable pageable);
}
