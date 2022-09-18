package com.example.JpaRepository.relation;

import com.example.JpaRepository.relation.domain.Channel;
import com.example.JpaRepository.relation.domain.ChannelHashTag;
import com.example.JpaRepository.relation.domain.HashTag;
import com.example.JpaRepository.relation.service.ChannelHashTagService;
import com.example.JpaRepository.relation.service.ChannelService;
import com.example.JpaRepository.relation.service.HashTagService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class EntityNNTest {

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ChannelHashTagService channelHashTagService;

    @Autowired
    private HashTagService hashTagService;

    private final String channelName = "channel";
    private final String hashTagName = "hashtag";

    @Test
    @Transactional
    public void 채널로저장() {
        // given
        Channel channel = channelService.save(channelName, hashTagName);

        // when
        Channel findChannel = channelService.findById(channel.getId());
        ChannelHashTag channelHashTag = findChannel.getChannelHashTags().get(0);

        // then
        assertThat(channelHashTag.getChannel().getId()).isEqualTo(channel.getId());
    }

    @Transactional
    public void 채널삭제() {
        // given
        Channel channel = channelService.save(channelName, hashTagName);
        ChannelHashTag channelHashTag = channelHashTagService.findById(channel.getChannelHashTags().get(0).getId());
        HashTag hashTag = channelHashTag.getHashTag();

        // when

        channelService.delete(channel.getId());

        // then
        assertThrows(RuntimeException.class, () -> channelHashTagService.findById(channelHashTag.getId()));
        assertThrows(RuntimeException.class, () -> hashTagService.findById(hashTag.getId()));
    }

    @Test
    public void 채널만삭제() {
        // given
        Channel channel = channelService.save(channelName, hashTagName);
        ChannelHashTag channelHashTag = channel.getChannelHashTags().get(0);
        HashTag hashTag = channelHashTag.getHashTag();

        // when

        channelService.delete(channel.getId());
        HashTag findHashTag = hashTagService.findById(hashTag.getId());

        // then
        assertThrows(RuntimeException.class, () -> channelHashTagService.findById(channelHashTag.getId()));
        System.out.println("findHashTag.getName() = " + findHashTag.getName());
        System.out.println("findHashTag.getChannelHashTags().size() = " + findHashTag.getChannelHashTags().size());
    }
}
