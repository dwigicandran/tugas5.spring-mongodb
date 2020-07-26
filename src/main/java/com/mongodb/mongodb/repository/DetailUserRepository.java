package com.mongodb.mongodb.repository;

import com.mongodb.mongodb.model.DetailUser;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailUserRepository extends MongoRepository <DetailUser,String>{
    
}