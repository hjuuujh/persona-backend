package com.persona.backend.DTO;

import com.persona.backend.model.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {

    private String id;


    private String email;


    private String password;


    private String name;

    private String token;

    public User user(){
        return User.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
}
