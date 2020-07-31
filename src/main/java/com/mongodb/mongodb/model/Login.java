package com.mongodb.mongodb.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document
public class Login {
    String username;
    String password;
}
