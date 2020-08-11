package com.mongodb.mongodb.controller;

import com.mongodb.mongodb.model.Transaksi;
import com.mongodb.mongodb.repository.TransaksiRepository;
import com.mongodb.mongodb.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("transaksi")
public class TransaksiController {
    @Autowired
    TransaksiRepository repo;
    @Autowired
    TransaksiService service;



    @GetMapping("")
    public List<Transaksi> getAllTransaksi(){ return repo.findAll(); }

    @PostMapping("")
    public Map<String, Object> saveTransaksi(@RequestBody Transaksi body) {
        return service.saveTransaksi(body);
    }

    @DeleteMapping("")
        //id dr param postman
    Map<String,Object>deleteTransaksi(@RequestParam String id){
        return service.deleteTransaksi(id);
    }

    @PutMapping("")
    Map <String,Object> updateTransaksi(@RequestBody Transaksi body){
        return service.updateTransaksi(body);
    }

    @GetMapping("/tanggal")
    public Transaksi getDataByTanggal(@RequestParam String search) {
        return service.getByTransaksiId(search);
    }

}
