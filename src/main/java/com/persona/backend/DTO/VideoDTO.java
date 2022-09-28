package com.persona.backend.DTO;

import com.persona.backend.model.Video;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class VideoDTO {

    private String id;

    private List<String> tag;

    private String name;

    private String title;

    private String videoUrl;

    private String imgUrl;

    private String category;

    private int hit;

    private int like;

    private LocalDateTime createdAt;

    private int videoShare;

    private List<String> likeUser;

    public static Video toEntity(final VideoDTO dto){
        return Video.builder()
                .id(dto.getId())
                .tag(dto.getTag())
                .name(dto.getName())
                .title(dto.getTitle())
                .createdAt(dto.getCreatedAt())
                .category(dto.getCategory())
                .imgUrl(dto.getImgUrl())
                .videoUrl(dto.getVideoUrl())
                .build();
    }
}
