package com.github.rgrantny.myvideo.service;


import com.github.rgrantny.myvideo.model.User;
import com.github.rgrantny.myvideo.model.Video;
import com.github.rgrantny.myvideo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    private VideoRepository repository;

    @Autowired

    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public List<Video> getAll() {
            return repository.findAll();
    }

    public Video getById(Integer videoId) {
        return repository.findById(videoId).orElse(null);
    }

    public Video create(Video video) {
        Video newVideo= new Video();
        newVideo.setVideoDescription(video.getVideoDescription());
        newVideo.setVideoLink(video.getVideoLink());
        return repository.save(newVideo);
    }

    public Video update(Integer videoId, Video video) {
        Video foundVideo = getById(videoId);
        foundVideo.setVideoLink((video.getVideoLink()));
        foundVideo.setVideoDescription(video.getVideoDescription());
        repository.save(foundVideo);
        return foundVideo;
    }

    public Video delete(Integer videoId) {
        Video deletedVideo = getById(videoId);
        repository.delete(deletedVideo);
        return deletedVideo;
    }
}
