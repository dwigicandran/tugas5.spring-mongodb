package com.mongodb.mongodb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.mongodb.model.User;
import com.mongodb.mongodb.repository.UserRepository;
import com.mongodb.mongodb.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
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


    @GetMapping("")
    public List<User> getAllUser(){
        return userRepository.findAll();

    }

    @PostMapping("")
    public Map<String, Object> saveUser(@RequestBody User body) {
        Map<String,Object> result = new HashMap<>();
        if(userService.saveUser(body)){
            result.put("success", true);
            result.put("message", "user berhasil ditambahkan");
        }else{
            result.put("success", false);
            result.put("message", "user gagal ditambahkan");
        }
        return result;
    }

    @DeleteMapping("")
    //id dr param postman
    Map<String,Object>deleteUser(@RequestParam String id){
        return userService.deleteUser(id);
    }

    @PutMapping("")
    Map <String,Object> updateUser(@RequestBody User body){
        return userService.updateUser(body);
    }


}