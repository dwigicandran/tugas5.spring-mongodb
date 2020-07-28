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
public class Transaksi {
    @Id
    private String id;
    private String tanggal;
    private int total;
    private Payment payment;
}
