package com.github.rgrantny.myvideo;

import com.github.rgrantny.myvideo.model.User;
import com.github.rgrantny.myvideo.model.Video;
import com.github.rgrantny.myvideo.repository.UserRepository;
import com.github.rgrantny.myvideo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyVideoApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    VideoRepository videoRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyVideoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User rich = new User();
        rich.setUserName("rgrant");
        rich.setPassword("pw1956");

        User rick = new User();
        rick.setUserName("rjgrant");
        rick.setPassword(("pw020"));

        userRepository.save(rich);
        userRepository.save(rick);

        Video video001 = new Video();
        video001.setVideoDescription("Hammer - 2Legit2Quit");
        video001.setVideoLink("https://www.youtube.com/watch?v=HFCv86Olk8E");

        Video video002 = new Video();
        video002.setVideoDescription("Metallica - Nothing Else Matters");
        video002.setVideoLink("https://www.youtube.com/watch?v=tAGnKpE4NCI");

        videoRepository.save(video001);
        videoRepository.save(video002);

    }
}
