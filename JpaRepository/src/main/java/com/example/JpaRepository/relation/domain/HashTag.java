package com.example.JpaRepository.relation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@NoArgsConstructor
public class HashTag {

    @Id
    @Column(name = "hashtag_id")
    private String id;

    private String name;

    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
    private List<ChannelHashTag> channelHashTags;

    public HashTag(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.channelHashTags = new ArrayList<>();
    }

    public void addChannelHashTag(ChannelHashTag channelHashTag) {
        this.channelHashTags.add(channelHashTag);
    }
}
