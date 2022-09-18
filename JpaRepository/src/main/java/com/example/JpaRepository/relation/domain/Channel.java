package com.example.JpaRepository.relation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@NoArgsConstructor
public class Channel {

    @Id
    @Column(name = "channel_id")
    private String id;

    private String name;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChannelHashTag> channelHashTags;

    public Channel(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.channelHashTags = new ArrayList<>();
    }


    public void addChannelHashTag(ChannelHashTag channelHashTag) {
        this.channelHashTags.add(channelHashTag);
    }
}
