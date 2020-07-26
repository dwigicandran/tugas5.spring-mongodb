package com.mongodb.mongodb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mongodb.mongodb.model.DetailUser;
import com.mongodb.mongodb.model.User;
import com.mongodb.mongodb.repository.DetailUserRepository;
import com.mongodb.mongodb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class DetailUserService {

    @Autowired
    UserRepository repo;
    @Autowired
    MongoTemplate mongotemp;

    public List<DetailUser> getAllDetail() {
        List<User> result = mongotemp.findAll(User.class);
        List<DetailUser> listDetail = new ArrayList<>();

        for(int i = 0; i < result.size(); i++){
            if(result.get(i).getDetailUser() != null)
                listDetail.add(result.get(i).getDetailUser());
        }
        return listDetail;
	}

    public Map<String, Object> saveDetailUser(DetailUser body, String id) {
        User userResult = repo.findById(id).get();
        Map<String, Object> resultMap = new HashMap<>();
        if (userResult != null) {
            User userSave = userResult;
            userResult.setDetailUser(body);
            try {
                repo.save(userSave);
                resultMap.put("success", true);
                resultMap.put("message", "user detail saved");
            } catch (Exception e) {
                resultMap.put("success", true);
                resultMap.put("message", "user detail faileds");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "no  data");
        }
        return resultMap;
    }

    public Map<String, Object> deleteDetail(String id) {
         Map<String, Object> result = new HashMap<>();
        try {
            //repo.deleteById(id);
            //objek query core mongo query
            Query query = new Query();
            //cari criteria dengan id database sama dengan id dr param
            query.addCriteria(Criteria.where("id").is(id));
            //objek update query update
            Update update = new Update();
            //update data dengan hilangkan detailUser
            update.unset("detailUser");
            mongotemp.updateMulti(query, update, User.class);
            
            result.put("success", true);
            result.put("message", "berhasil dihapus");
        } catch (final Exception e) {
            result.put("success", false);
            result.put("message", "gagal dihapus");
        }
        return result;
    }

    public Map<String, Object> updateDetail( DetailUser body, String id) {
        //ambil data berdasarkan id 
        User userResult = repo.findById(id).get();
         Map<String, Object> resultMap = new HashMap<>();
         //jika data ada
        if (userResult != null) {
                User userSave = userResult;
                //set detail user berdasarkan input
                userResult.setDetailUser(body);
            try {
                
                repo.save(userSave);
                resultMap.put("success", true);
                resultMap.put("message", "berhasil diupdate");
            } catch (final Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "gagal diupdate");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "null");
        }
        return resultMap;
    }

	public DetailUser getByUserId(String id ){
		User userResult = repo.findById(id).get();
        DetailUser detailUser = userResult.getDetailUser();
        return detailUser;
	}



	
    
}