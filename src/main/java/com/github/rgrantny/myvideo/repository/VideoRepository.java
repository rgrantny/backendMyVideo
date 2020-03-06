package com.github.rgrantny.myvideo.repository;

import com.github.rgrantny.myvideo.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
