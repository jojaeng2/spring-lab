package com.example.JpaRepository.relation.service;


import com.example.JpaRepository.relation.domain.Channel;
import com.example.JpaRepository.relation.domain.ChannelHashTag;
import com.example.JpaRepository.relation.domain.HashTag;
import com.example.JpaRepository.relation.repository.ChannelRepository;
import com.example.JpaRepository.relation.repository.HashTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChannelService {

    private final ChannelRepository channelRepository;
    private final HashTagRepository hashTagRepository;

    @Transactional
    public Channel save(String channelName, String hashTagName) {
        Channel channel = new Channel(channelName);
        HashTag hashTag = new HashTag(hashTagName);
        new ChannelHashTag(channel, hashTag);
        return channelRepository.save(channel);
    }

    @Transactional(readOnly = true)
    public Channel findById(String id) {
        return channelRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void delete(String id) {
        Channel channel = channelRepository.findById(id).orElseThrow(RuntimeException::new);
        channelRepository.delete(channel);
    }
}
