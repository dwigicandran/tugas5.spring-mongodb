package com.mongodb.mongodb.repository;

import java.util.Optional;

import com.mongodb.mongodb.model.LayananKurir;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LayananKurirRepository extends MongoRepository <LayananKurir,String>{

	Optional<LayananKurir> findByNama(String nama);
    
}