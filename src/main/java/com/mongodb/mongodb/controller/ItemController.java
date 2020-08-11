package com.mongodb.mongodb.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mongodb.mongodb.model.Item;
import com.mongodb.mongodb.repository.ItemRepository;
import com.mongodb.mongodb.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    ItemRepository repo;
    @Autowired
    ItemService service;

    @GetMapping("")
    public List<Item> getAllItem(){
        return repo.findAll();

    }

    @PostMapping("")
    public Map<String, Object> saveItem(@RequestBody Item body) {
        return service.saveItem(body);
    }
    
    @DeleteMapping("")
    //id dr param postman
    Map<String,Object>deleteItem(@RequestParam String id){
        return service.deleteItem(id);
    }

    @PutMapping("")
    Map <String,Object> updateItem(@RequestBody Item body){
        return service.updateItem(body);
    }
    @GetMapping("ById")
    public Optional<Item> getItemById(@RequestParam String id){
        return repo.findById(id);
    }
}