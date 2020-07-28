package com.mongodb.mongodb.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Login {
    private String username;
    private String password;

}
