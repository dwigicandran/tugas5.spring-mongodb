package com.mongodb.mongodb.controller;

import java.util.List;
import java.util.Map;

import com.mongodb.mongodb.model.LayananKurir;
import com.mongodb.mongodb.repository.LayananKurirRepository;
import com.mongodb.mongodb.service.LayananKurirService;

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
@RequestMapping("layananKurir")
public class LayananKurirController {
    
    @Autowired
    LayananKurirRepository repo;
    @Autowired
    LayananKurirService service;

    
    @GetMapping("")
    public List<LayananKurir> getAllLayananKurir(){
        return repo.findAll();

    }

    @PostMapping("")
    public Map<String, Object> saveLayananKurir(@RequestBody LayananKurir body) {
        return service.saveLayananKurir(body);
    }
    
    @DeleteMapping("")
    //id dr param postman
    Map<String,Object>deleteLayananKurir(@RequestParam String id){
        return service.deleteLayananKurir(id);
    }

    @PutMapping("")
    Map <String,Object> updateLayananKurir(@RequestBody LayananKurir body){
        return service.updateLayananKurir(body);
    }

}