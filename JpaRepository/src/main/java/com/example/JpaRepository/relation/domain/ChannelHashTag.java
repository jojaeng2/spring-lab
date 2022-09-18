package com.example.JpaRepository.relation.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class ChannelHashTag {

    @Id
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hashtag_id")
    private HashTag hashTag;

    public ChannelHashTag(Channel channel, HashTag hashTag) {
        this.id = UUID.randomUUID().toString();
        this.channel = channel;
        this.hashTag = hashTag;

        channel.addChannelHashTag(this);
        hashTag.addChannelHashTag(this);
    }
}
