package com.example.JpaRepository.JpaRepositoryInterface.repository;

import com.example.JpaRepository.JpaRepositoryInterface.domain.Channels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelsRepository extends JpaRepository<Channels, String> {
}
