package com.mongodb.mongodb.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.mongodb.mongodb.model.Item;
import com.mongodb.mongodb.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ItemRepository repo;

	public Map<String, Object> saveItem(Item body) {
		Map<String, Object> result = new HashMap<>();
        try {
            repo.save(body);
            result.put("success", true);
            result.put("message", "Item successfuly added");
        } catch (Exception e) {
            result.put("success", true);
            result.put("message", "Item failed added");
        }
        return result;
	}

	public Map<String, Object> deleteItem(String id) {
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

	public Map<String, Object> updateItem(Item body) {
		Optional<Item> result = repo.findById(body.getId());
         Map<String, Object> resultMap = new HashMap<>();
        if (result != null) {
            try {
                repo.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "Item successfuly updated");
            } catch (final Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "Item failed updated");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "null");
        }
        return resultMap;
	}

}