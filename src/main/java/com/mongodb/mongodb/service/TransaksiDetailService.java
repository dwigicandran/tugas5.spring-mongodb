package com.mongodb.mongodb.service;

import com.mongodb.mongodb.model.*;
import com.mongodb.mongodb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TransaksiDetailService {

    @Autowired
    TransaksiDetailRepository TDRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    ItemRepository itemRepo;
    @Autowired
    LayananKurirRepository layananKurirRepo;
    @Autowired
    TransaksiRepository transaksiRepo;

    @Autowired
    MongoTemplate mongotemp;


    public List<TransaksiDetail> getAllTD() {
        return TDRepo.findAll();
    }

    public Map<String, Object> addTD(TransaksiDetail body) {
        Map<String,Object> resultMap = new HashMap<>();
            try {


                //tambahan untuk set transaksi detail
                    TransaksiDetail transaksiDetail = new TransaksiDetail();
                    transaksiDetail.setUser(body.getUser());
                    transaksiDetail.setBerat(body.getBerat());
                    transaksiDetail.setHarga(body.getHarga());
                    transaksiDetail.setItem(body.getItem());
                    transaksiDetail.setJumlah(body.getJumlah());
                    transaksiDetail.setLayanankurir(body.getLayanankurir());
                    transaksiDetail.setTransaksi(body.getTransaksi());

                TDRepo.save(transaksiDetail);
                resultMap.put("success", true);
                resultMap.put("message", "Succesfully add data");
            }catch (Exception e){
                resultMap.put("success",false);
                resultMap.put("message","Failed add data" + e);
            }
        return resultMap;
    }

    public Map<String, Object> updateTransaksiDetail(TransaksiDetail body) {
        Optional<TransaksiDetail> result = TDRepo.findById(body.getId());
        Map<String, Object> resultMap = new HashMap<>();
        if (result.isPresent()) {
            try {
                TDRepo.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "Transaksi detail updated");
            } catch (Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "Transaksi detail  updated failed");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "no transaksi detail data");
        }
        return resultMap;
    }

    public Map<String, Object> deleteTransaksiDetail(String id) {
        Optional<TransaksiDetail> result = TDRepo.findById(id);
        Map<String ,Object> resultMap = new HashMap<>();
        try {
            TDRepo.deleteById(id);
            resultMap.put("success", true);
            resultMap.put("message", "Transaksi detail deleted");
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("message", "Transaksi detail delete failed");
        }
        return resultMap;
    }
}
