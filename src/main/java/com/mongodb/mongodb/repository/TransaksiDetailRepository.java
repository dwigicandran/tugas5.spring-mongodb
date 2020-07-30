package com.mongodb.mongodb.repository;

import com.mongodb.mongodb.model.TransaksiDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiDetailRepository extends MongoRepository <TransaksiDetail,String> {
}
