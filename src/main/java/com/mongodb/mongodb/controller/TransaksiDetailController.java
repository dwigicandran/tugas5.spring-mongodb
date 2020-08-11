package com.mongodb.mongodb.controller;

import com.mongodb.mongodb.model.TransaksiDetail;
import com.mongodb.mongodb.repository.TransaksiDetailRepository;
import com.mongodb.mongodb.service.TransaksiDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("transaksidetail")
public class TransaksiDetailController {

    @Autowired
    TransaksiDetailRepository repo;
    @Autowired
    MongoTemplate mongotemp;
    @Autowired
    TransaksiDetailService service;

    @GetMapping("")
    public List<TransaksiDetail> getAllTransaksiDetail(){
        return service.getAllTD();
    }

    @PostMapping("")
    public Map<String,Object> addTransaksiDetail(@RequestBody TransaksiDetail body){
        return service.addTD(body);
    }

    @PutMapping("")
    public Map<String,Object> updateTransaksiDetail(@RequestBody TransaksiDetail body){
        return service.updateTransaksiDetail(body);
    }
    @DeleteMapping("")
    Map<String,Object>deleteTransaksiDetail(@RequestParam String id){
        return service.deleteTransaksiDetail(id);
    }


}
