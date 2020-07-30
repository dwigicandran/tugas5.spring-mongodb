package com.mongodb.mongodb.service;

import com.mongodb.mongodb.model.*;
import com.mongodb.mongodb.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaymentService {
    @Autowired
    TransaksiRepository transaksiRepository;
    @Autowired
    MongoTemplate mongoTemplate;


    public List<Payment> getAllPayment() {
        List<Transaksi> result = mongoTemplate.findAll(Transaksi.class);
        List<Payment> listPayment = new ArrayList<>();

        for(int i = 0; i < result.size(); i++){
            if(result.get(i).getPayment() != null)
                listPayment.add(result.get(i).getPayment());
        }
        return listPayment;
    }

    public Map<String, Object> savePayment(Payment body, String id) {
        Transaksi result = transaksiRepository.findById(id).get();
        Map<String,Object> resultMap = new HashMap<>();
        if (result != null){
            Transaksi transaksi = result;
            transaksi.setPayment(body);
            try {
                transaksiRepository.save(transaksi);
                resultMap.put("success",true);
                resultMap.put("message","Payment succassfully added");
            }catch (Exception e){
                resultMap.put("success",false);
                resultMap.put("meessage","Payment failed added");
            }
        }else {
            resultMap.put("success",false);
            resultMap.put("message","no data id");
        }
        return resultMap;
    }

    public Map<String, Object> deletePayment(String id) {
        Map<String, Object> result = new HashMap<>();
        try {
            //repo.deleteById(id);
            //objek query core mongo query
            Query query = new Query();
            //cari criteria dengan id database sama dengan id dr param
            query.addCriteria(Criteria.where("id").is(id));
            //objek update query update
            Update update = new Update();
            //update data dengan hilangkan detailUser
            update.unset("payment");
            mongoTemplate.updateMulti(query, update, Transaksi.class);

            result.put("success", true);
            result.put("message", "berhasil dihapus");
        } catch (final Exception e) {
            result.put("success", false);
            result.put("message", "gagal dihapus");
        }
        return result;
    }

    public Map<String, Object> updatePayment(Payment body, String id) {
        Transaksi result = transaksiRepository.findById(id).get();
        Map<String, Object> resultMap = new HashMap<>();
        //jika data ada
        if (result != null) {
            Transaksi transaksi = result;
            //set payment user berdasarkan input
            result.setPayment(body);
            try {

                transaksiRepository.save(transaksi);
                resultMap.put("success", true);
                resultMap.put("message", "berhasil diupdate");
            } catch (final Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "gagal diupdate");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "null");
        }
        return resultMap;
    }

    public Payment getByTransaksiId(String id) {
        Transaksi result = transaksiRepository.findById(id).get();
        Payment payment = result.getPayment();
        return payment;
    }
}
