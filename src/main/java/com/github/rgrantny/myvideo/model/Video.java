package com.github.rgrantny.myvideo.model;

import com.github.rgrantny.myvideo.repository.VideoRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Video {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer videoId;
    private String videoLink;
    private String videoDescription;

    public Video() {
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", videoLink='" + videoLink + '\'' +
                ", videoDescription='" + videoDescription + '\'' +
                '}';
    }
}
