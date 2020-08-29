package com.mongodb.mongodb.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mongodb.mongodb.model.Pembayaran;
import com.mongodb.mongodb.repository.PembayaranRepository;
import com.mongodb.mongodb.service.PembayaranService;

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
@RequestMapping("pembayaran")
public class PembayaranController {

    @Autowired
    PembayaranRepository repo;
    @Autowired
    PembayaranService service;



    @GetMapping("")
    public List<Pembayaran> getAllPembayarans(){ return repo.findAll(); }

    @PostMapping("")
    public Map<String, Object> savePembayaran(@RequestBody Pembayaran body) {
        return service.savePembayaran(body);
    }

    @DeleteMapping("")
    Map<String,Object>deletePembayaran(@RequestParam String id){
        return service.deletePembayaran(id);
    }

    @PutMapping("")
    Map <String,Object> updatePembayaran(@RequestBody Pembayaran body){
        return service.updatePembayaran(body);
    }

    @GetMapping("/ById")
    public Optional<Pembayaran> getDataByPembayaran(@RequestParam String id) {
        return service.getByPembayaranId(id);
    }

    
}