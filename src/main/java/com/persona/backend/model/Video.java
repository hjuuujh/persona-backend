package com.persona.backend.model;

import com.persona.backend.DTO.VideoDTO;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document(collection = "video")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video {

    @Id
    @Field("_id")
    private String id;
    private String userId;

    @Field("tag")
    private List<String> tag;

    @Field("name")
    private String name;

    @Field("title")
    private String title;

    @Field("videoUrl")
    private String videoUrl;

    @Field("imgUrl")
    private String imgUrl;

    @Field("category")
    private String category;

    @Field("hit")
    private int hit = 0;

    @Field("like")
    private int like = 0;

    @Field("createdAt")

    @CreatedDate
    private LocalDateTime createdAt;

    @Field("videoShare")
    private int videoShare = 0;

    @Field("likeUser")
    private List<String> likeUser;

    @Version private Long version;
    public static VideoDTO toDTO(final Video video){
        return VideoDTO.builder()
                .id(video.getId())
                .tag(video.getTag())
                .name(video.getName())
                .title(video.getTitle())
                .createdAt(video.getCreatedAt())
                .category(video.getCategory())
                .imgUrl(video.getImgUrl())
                .videoUrl(video.getVideoUrl())
                .build();

    }
}
