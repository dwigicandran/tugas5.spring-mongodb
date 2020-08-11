package com.mongodb.mongodb.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Payment {
    @MongoId
    private String id;
    private  String nama,code,jenis;
}
