package com.mongodb.mongodb.controller;

import java.util.List;
import java.util.Map;

import com.mongodb.mongodb.model.DetailUser;
import com.mongodb.mongodb.repository.DetailUserRepository;
import com.mongodb.mongodb.service.DetailUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("detailUser")
public class DetailUserController {
    
    @Autowired
    DetailUserRepository repo;
    @Autowired
    DetailUserService service;

    @GetMapping("")
    public List<DetailUser> getAllDetail(){
        return service.getAllDetail();

    }

    @PostMapping("")
    public Map<String, Object> saveDetailUser(@RequestBody DetailUser body,String id) {
        return service.saveDetailUser(body,id);
    }
    
    @DeleteMapping("")
    //id dr param postman
    Map<String,Object>deleteDetailUser(@RequestParam String id){
        return service.deleteDetail(id);
    }

    @PutMapping("")
    Map <String,Object> updateDetailUser(@RequestBody DetailUser body,String id){
        return service.updateDetail(body,id);
    }

    @GetMapping("/userid")
    public DetailUser getDataByUserId(String id) {
        return service.getByUserId(id);
    }

}