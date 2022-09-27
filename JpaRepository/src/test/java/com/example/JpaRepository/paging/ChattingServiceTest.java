package com.example.JpaRepository.paging;

import com.example.JpaRepository.relation.domain.ChatLog;
import com.example.JpaRepository.relation.service.ChattingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ChattingServiceTest {

    @Autowired
    private ChattingService service;

    @Test
    @Transactional
    void 채팅로그반환() {
        // given
        for(int i=0; i<100; i++) {
            ChatLog chatLog = new ChatLog("test " + i, i, "jo");
            service.save(chatLog);
        }
        
        // when
        List<ChatLog> logs = service.findChatLog(1);
        
        // then
        for (ChatLog log : logs) {
            System.out.println("log = " + log.getMessage());
            System.out.println("log.getIdx() = " + log.getIdx());
        }
    }
}
