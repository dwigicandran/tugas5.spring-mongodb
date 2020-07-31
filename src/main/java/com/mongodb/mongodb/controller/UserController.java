package com.mongodb.mongodb.controller;

import java.util.*;

import com.mongodb.mongodb.model.User;
import com.mongodb.mongodb.repository.UserRepository;
import com.mongodb.mongodb.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    UserRepository userRepository;    
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @PostMapping("")
    public Map<String, Object> saveUser(@RequestBody User body) {
        String password = passwordEncoder.encode(body.getPassword());
        body.setPassword(password);
        return userService.saveUser(body);
    }

    @DeleteMapping("")
    //id dr param postman
    Map<String,Object>deleteUser(@RequestParam String id){
        return userService.deleteUser(id);
    }

    @PutMapping("")
    Map <String,Object> updateUser(@RequestBody User body){
        String password = passwordEncoder.encode(body.getPassword());
        body.setPassword(password);
        return userService.updateUser(body);
    }

    @GetMapping("/page")
    public ResponseEntity<Map<String ,Object>> getAllUsers(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size)
    { return userService.getAllUsername(search,page,size); }



}