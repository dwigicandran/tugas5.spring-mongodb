package com.mongodb.mongodb.controller;

import com.mongodb.mongodb.model.Login;
import com.mongodb.mongodb.model.User;
import com.mongodb.mongodb.service.LoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService service;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("")
    public Map<String, Object> loginUser(@RequestBody Login body) {
        System.out.println(body.toString());
        Optional<User> result = service.findByUsername(body.getUsername());
        Map<String, Object> resultMap = new HashMap<>();

        if (result != null) {
            boolean isMatch = passwordEncoder.matches(body.getPassword(), result.get().getPassword());
            if (isMatch) {
                String token = Jwts.builder()
                        .setSubject(body.getUsername())
                        .claim("role", result.get().getRole())
                        .signWith(SignatureAlgorithm.HS256, "chand")
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                        .compact();
                resultMap.put("success", true);
                resultMap.put("record", result);
                resultMap.put("token", token);
            }
        } else {
            resultMap.put("success", false);
        }
        return resultMap;

    }

}
