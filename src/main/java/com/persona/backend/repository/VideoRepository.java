package com.persona.backend.repository;

import com.persona.backend.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends MongoRepository<Video, String> {

    Video findByTitle(String title);
    Video findByNameAndTitle(String name, String title);
    Boolean existsVideoByNameAndTitle(String name, String title);

}
