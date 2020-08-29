package com.mongodb.mongodb.repository;

import com.mongodb.mongodb.model.Pembayaran;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PembayaranRepository extends MongoRepository<Pembayaran, String> {
    
}