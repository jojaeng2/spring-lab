package com.example.JpaRepository.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {

    @Id
    private Long id;
    private String userName;

    public Users(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}
