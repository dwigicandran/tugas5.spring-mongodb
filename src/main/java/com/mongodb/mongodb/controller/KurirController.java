package com.mongodb.mongodb.controller;

import java.util.List;
import java.util.Map;

import com.mongodb.mongodb.model.Kurir;
import com.mongodb.mongodb.repository.KurirRepository;
import com.mongodb.mongodb.service.KurirService;

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
@RequestMapping("kurir")
public class KurirController {
    @Autowired
    KurirRepository repo;
    @Autowired
    KurirService service;

    @GetMapping("")
    public List<Kurir> getAllKurir(){
        return repo.findAll();

    }

    @PostMapping("")
    public Map<String, Object> saveKurir(@RequestBody Kurir body) {
        return service.saveKurir(body);
    }
    
    @DeleteMapping("")
    //id dr param postman
    Map<String,Object>deleteKurir(@RequestParam String id){
        return service.deleteKurir(id);
    }

    @PutMapping("")
    Map <String,Object> updateKurir(@RequestBody Kurir body){
        return service.updateKurir(body);
    }
    
}