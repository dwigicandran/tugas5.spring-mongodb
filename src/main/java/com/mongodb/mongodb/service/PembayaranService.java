package com.mongodb.mongodb.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.mongodb.mongodb.model.Pembayaran;
import com.mongodb.mongodb.repository.PembayaranRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PembayaranService {

    @Autowired
    PembayaranRepository repo;

	public Map<String, Object> savePembayaran(Pembayaran body) {
		Map<String, Object> resultMap = new HashMap<>();
            try {
                repo.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "insert pembayaran berhasil");
            } catch (Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "insert pembayaran gagal");
            }
            return resultMap;
	}

	public Map<String, Object> deletePembayaran(String id) {
        Map<String ,Object> resultMap = new HashMap<>();
        try {
            repo.deleteById(id);
            resultMap.put("success", true);
            resultMap.put("message", "Pembayaran deleted");
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("message", "Pembayaran delete failed");
        }
        return resultMap;
	}

	public Map<String, Object> updatePembayaran(Pembayaran body) {
        Optional<Pembayaran> result = repo.findById(body.getId());
        Map<String, Object> resultMap = new HashMap<>();
        if (result.isPresent()) {
            try {
                repo.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "Pembayaran updated");
            } catch (Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "Pembayaran updated failed");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "no Pembayaran data");
        }
        return resultMap;
	}

	public Optional<Pembayaran> getByPembayaranId(String id) {
		return repo.findById(id);
	}
    
}