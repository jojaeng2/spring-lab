package com.example.JpaRepository.relation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class ChatLog {

    @Id
    private String id;
    private String message;
    private String senderName;
    private int idx;

    public ChatLog(String message, int idx, String senderName) {
        this.id = UUID.randomUUID().toString();
        this.message = message;
        this.senderName = senderName;
        this.idx = idx;
    }
}
