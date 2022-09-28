package com.persona.backend.model;

import com.persona.backend.DTO.UserDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @Field("_id")
    private String id;
    @Field("email")
    private String email;
    @Field("password")
    private String password;
    @Field("name")
    private String name;

    public UserDTO userDto(){
        return UserDTO.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
}
