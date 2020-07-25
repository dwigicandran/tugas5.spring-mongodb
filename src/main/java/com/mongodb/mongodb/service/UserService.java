package com.mongodb.mongodb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mongodb.mongodb.model.User;
import com.mongodb.mongodb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public ResponseEntity<Map<String, Object>> getAllUsername(String search, int page, int size) {
		try {
            List<User> users = new ArrayList<User>();
            Pageable pageable = PageRequest.of(page,size);

            Page<User> userPage;
            if (search == null) {
                userPage = userRepository.findAll(pageable);
            }else {
                userPage = userRepository.findByUsernameContaining(search, pageable);
            }
            users = userPage.getContent();

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("users", users);
            response.put("currentPage", userPage.getNumber());
            response.put("totalItems", userPage.getTotalElements());
            response.put("totalPages", userPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}



    
}