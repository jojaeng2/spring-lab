package com.example.JpaRepository.relation.repository;

import com.example.JpaRepository.relation.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, String> {
}
