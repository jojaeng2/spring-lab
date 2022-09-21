package com.example.JpaRepository.JpaRepositoryInterface.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Channels {

    @Id
    private String id;

    private String name;

    public Channels(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
