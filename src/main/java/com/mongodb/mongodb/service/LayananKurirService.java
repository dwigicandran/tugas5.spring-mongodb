package com.mongodb.mongodb.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.mongodb.mongodb.model.LayananKurir;
import com.mongodb.mongodb.repository.LayananKurirRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LayananKurirService {
    
    @Autowired
    LayananKurirRepository repo;

	public Map<String, Object> saveLayananKurir(LayananKurir body) {
		Map<String, Object> result = new HashMap<>();
        try {
            repo.save(body);
            result.put("success", true);
            result.put("message", "LayananKurir successfuly added");
        } catch (Exception e) {
            result.put("success", true);
            result.put("message", "LayananKurir failed added");
        }
        return result;
	}

	public Map<String, Object> deleteLayananKurir(String id) {
		Map<String, Object> result = new HashMap<>();
        try {
            repo.deleteById(id);
            result.put("success", true);
            result.put("message", "Succesfuly deleted");
        } catch (final Exception e) {
            result.put("success", false);
            result.put("message", "Failed deleted");
        }
        return result;
	}

	public Map<String, Object> updateLayananKurir(LayananKurir body) {
		Optional<LayananKurir> result = repo.findById(body.getId());
         Map<String, Object> resultMap = new HashMap<>();
        if (result != null) {
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
            resultMap.put("message", "null");
        }
        return resultMap;
	}
    
}