package com.mongodb.mongodb.service;

import com.mongodb.mongodb.model.Transaksi;
import com.mongodb.mongodb.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TransaksiService {

    @Autowired
    TransaksiRepository repo;

    public Map<String, Object> saveTransaksi(Transaksi body) {
        Map<String, Object> resultMap = new HashMap<>();
            try {
                repo.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "insert transaksi berhasil");
            } catch (Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "insert transaksi gagal");
            }
            return resultMap;
    }

    public Map<String, Object> deleteTransaksi(String id) {
        Optional<Transaksi> result = repo.findById(id);
        Map<String ,Object> resultMap = new HashMap<>();
        try {
            repo.deleteById(id);
            resultMap.put("success", true);
            resultMap.put("message", "Transaksi deleted");
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("message", "Transaksi delete failed");
        }
        return resultMap;
    }

    public Map<String, Object> updateTransaksi(Transaksi body) {
        Optional<Transaksi> result = repo.findById(body.getId());
        Map<String, Object> resultMap = new HashMap<>();
        if (result.isPresent()) {
            try {
                repo.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "Transaksi updated");
            } catch (Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "Transaksi updated failed");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "no transaksi data");
        }
        return resultMap;
    }

    public Transaksi getByTransaksiId(String search) {
        return repo.findByTanggalContaining(search);
    }
}
