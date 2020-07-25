package com.mongodb.mongodb.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.mongodb.mongodb.model.User;
import com.mongodb.mongodb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Boolean saveUser(final User body) {
        try {
            userRepository.save(body);
            return true;
        } catch (final Exception e) {
            return false;
        }
    }

    public Map<String, Object> deleteUser(String id) {
        Map<String, Object> result = new HashMap<>();
        try {
            userRepository.deleteById(id);
            result.put("success", true);
            result.put("message", "berhasil dihapus");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "gagal dihapus");
        }
        return result;
    }

    public Map<String, Object> updateUser(User body) {
        Optional<User> result = userRepository.findById(body.getId());
        Map<String,Object> resultMap = new HashMap<>();
        if(result != null){
            try{
                userRepository.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "berhasil diupdate");
            }catch (Exception e){
                resultMap.put("success", false);
                resultMap.put("message", "gagal diupdate");
            }
        }else{
            resultMap.put("success", false);
            resultMap.put("message", "null");
        }
        return resultMap;
	}



    
}