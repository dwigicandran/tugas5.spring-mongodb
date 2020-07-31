package com.mongodb.mongodb.service;

import java.util.*;

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



	public Map<String, Object> saveUser(User body) {
		Optional<User> userResult = userRepository.findByUsername(body.getUsername());
        Map<String, Object> resultMap = new HashMap<>();


        if (userResult.isPresent()) {
            resultMap.put("success", false);
            resultMap.put("message", "user telah terdaftar");
        } else {
            try {
                userRepository.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "insert user berhasil");
            } catch (Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "insert user gagal");
            }
        }
        return resultMap;
	}
	public Map<String, Object> deleteUser(String id) {
		Optional<User> userResult = userRepository.findById(id);
        Map<String, Object> resultMap = new HashMap<>();
        if (userResult.isPresent()) {
            try {
                userRepository.deleteById(id);
                resultMap.put("success", true);
                resultMap.put("message", "user deleted");
            } catch (Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "user delete failed");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "no user data");
        }
        return resultMap;
	}
	public Map<String, Object> updateUser(User body) {
        Optional<User> userResult = userRepository.findById(body.getId());
        Map<String, Object> resultMap = new HashMap<>();


        if (userResult.isPresent()) {
            try {
                userRepository.save(body);
                resultMap.put("success", true);
                resultMap.put("message", "user updated");
            } catch (Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "user updated failed");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "no user data");
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