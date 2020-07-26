package com.mongodb.mongodb.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.mongodb.mongodb.model.Kurir;
import com.mongodb.mongodb.repository.KurirRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KurirService {

    @Autowired
    KurirRepository repo;

	public Map<String, Object> saveKurir(Kurir body) {
		Map<String, Object> result = new HashMap<>();
        try {
            repo.save(body);
            result.put("success", true);
            result.put("message", "Kurir successfuly added");
        } catch (Exception e) {
            result.put("success", true);
            result.put("message", "Kurir failed added");
        }
        return result;
	}

	public Map<String, Object> deleteKurir(String id) {
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

	public Map<String, Object> updateKurir(Kurir body) {
		Optional<Kurir> result = repo.findById(body.getId());
         Map<String, Object> resultMap = new HashMap<>();
        if (result != null) {
            try {
                repo.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "Kurir successfuly updated");
            } catch (final Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "Kurir failed updated");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "null");
        }
        return resultMap;
	}
    
}