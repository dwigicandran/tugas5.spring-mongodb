package com.mongodb.mongodb.repository;

import com.mongodb.mongodb.model.Transaksi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiRepository extends MongoRepository <Transaksi,String> {
    Transaksi findByTanggalContaining(String search);
}
