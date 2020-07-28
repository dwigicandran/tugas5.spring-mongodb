package com.mongodb.mongodb.controller;

import com.mongodb.mongodb.model.DetailUser;
import com.mongodb.mongodb.model.Payment;
import com.mongodb.mongodb.model.Transaksi;
import com.mongodb.mongodb.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    PaymentService service;

    @GetMapping("")
    public List<Payment> getAllPayment(){
        return service.getAllPayment();

    }

    @PostMapping("")
    public Map<String, Object> savePayment(@RequestBody Payment body, String id) {
        return service.savePayment(body,id);
    }

    @DeleteMapping("")
        //id dr param postman
    Map<String,Object>deletePayment(@RequestParam String id){
        return service.deletePayment(id);
    }

    @PutMapping("")
    Map <String,Object> updatePayment(@RequestBody Payment body,String id){
        return service.updatePayment(body,id);
    }

    @GetMapping("/transaksiid")
    public Payment getDataByTransaksiId(String id) {
        return service.getByTransaksiId(id);
    }

}