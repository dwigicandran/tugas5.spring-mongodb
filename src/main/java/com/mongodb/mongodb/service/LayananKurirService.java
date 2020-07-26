package com.mongodb.mongodb.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.mongodb.mongodb.model.LayananKurir;
import com.mongodb.mongodb.repository.KurirRepository;
import com.mongodb.mongodb.repository.LayananKurirRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LayananKurirService {
    
    @Autowired
    LayananKurirRepository repo;
    @Autowired
    KurirRepository kurirRepo;


	public Map<String, Object> saveLayananKurir(LayananKurir body) {
		Optional<LayananKurir> layanan = repo.findByNama(body.getNama());
        Map<String, Object> resultMap = new HashMap<>();
        if (layanan.isPresent()) {
            resultMap.put("success", false);
            resultMap.put("message", "Layanan telah terdaftar");
        } else {
            try {
                repo.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "insert Layanan berhasil");
            } catch (Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "insert Layanan gagal");
            }
        }
        return resultMap;
	}

	public Map<String, Object> deleteLayananKurir(String id) {
        Optional<LayananKurir> layanan = repo.findById(id);
        Map<String, Object> result = new HashMap<>();
        if (layanan.isPresent()) {
            try {
                repo.deleteById(id);
                result.put("success", true);
                result.put("message", "Succesfuly deleted");
            } catch (final Exception e) {
                result.put("success", false);
                result.put("message", "Failed deleted");
            }
        }else {
            result.put("success", false);
            result.put("message", "no data");
        }
        return result;
	}

	public Map<String, Object> updateLayananKurir(LayananKurir body) {
		Optional<LayananKurir> result = repo.findById(body.getId());
         Map<String, Object> resultMap = new HashMap<>();
        if (result.isPresent()) {
            try {
                repo.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "LayananKurir successfuly updated");
            } catch (final Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "LayananKurir failed updated");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "no data");
        }
        return resultMap;
	}
    
}