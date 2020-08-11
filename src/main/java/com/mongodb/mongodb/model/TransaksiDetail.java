package com.mongodb.mongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class TransaksiDetail {
    @Id
    private String id;
    @DBRef
    private User user;
    @DBRef
    private Transaksi transaksi;
    @DBRef
    private Item item;
    @DBRef
    private LayananKurir layanankurir;
    private String jumlah;
    private String berat;
    private String harga;
}
