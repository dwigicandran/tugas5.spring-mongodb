package com.mongodb.mongodb.service;

import com.mongodb.mongodb.model.User;
import com.mongodb.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    UserRepository repo;


    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }
}
