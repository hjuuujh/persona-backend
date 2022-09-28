package com.persona.backend.service;

import com.persona.backend.model.Video;
import com.persona.backend.repository.VideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public Video create(final Video video){
        logger.info("error : {}",video);
        if(video == null) {
            throw new RuntimeException("Invalid arguments");
        }

        final String title = video.getTitle();
        final String name = video.getName();

        if(videoRepository.existsVideoByNameAndTitle(name, title)){
            logger.info("Title already exist {} : {}", name, title);
            throw  new RuntimeException("Title already exist");
        }

        return videoRepository.save(video);

    }
}
