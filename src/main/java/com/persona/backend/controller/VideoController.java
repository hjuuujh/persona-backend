package com.persona.backend.controller;

import com.persona.backend.DTO.ResponseDTO;
import com.persona.backend.DTO.UserDTO;
import com.persona.backend.DTO.VideoDTO;
import com.persona.backend.model.Video;
import com.persona.backend.security.TokenProvider;
import com.persona.backend.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
public class VideoController {

    private VideoService videoService;
    private TokenProvider tokenProvider;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public VideoController(VideoService videoService, TokenProvider tokenProvider ){
        this.videoService = videoService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createVideo(@AuthenticationPrincipal String userId, @RequestBody VideoDTO videoDTO){
        try {

            Video video = VideoDTO.toEntity(videoDTO);
            logger.info("createdAt: {}", video.getCreatedAt());
            logger.info("hit: {}", video.getHit());

            video.setId(null);
            video.setUserId(userId);
            Video createdVideo = videoService.create(video);

            VideoDTO responseVideoDTO = Video.toDTO(createdVideo);
            return ResponseEntity.ok(responseVideoDTO);
        }catch (Exception e){
            logger.info("ereror: {}", e);

            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }
}
