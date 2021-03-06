package com.mongodb.mongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Item {
    @Id
    private String id;

    private String nama;
    private String description;
    private int stock,harga,terjual,berat;


}