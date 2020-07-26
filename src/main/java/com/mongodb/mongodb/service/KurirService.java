package com.mongodb.mongodb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.mongodb.model.Kurir;
import com.mongodb.mongodb.model.LayananKurir;
import com.mongodb.mongodb.repository.LayananKurirRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class KurirService {

    @Autowired
    LayananKurirRepository repo;
    @Autowired
    MongoTemplate mongotemp;


    public List<Kurir> getAllKurir() {
        List<LayananKurir> result = mongotemp.findAll(LayananKurir.class);
        List<Kurir> listKurir = new ArrayList<>();

        for(int i = 0; i < result.size(); i++){
            if(result.get(i).getKurir() != null)
                listKurir.add(result.get(i).getKurir());
        }
        return listKurir;
	}

	public Map<String, Object> saveKurir(Kurir body,String id) {
		LayananKurir layanan  = repo.findById(id).get();
        Map<String, Object> resultMap = new HashMap<>();
        if (layanan != null) {
            LayananKurir kurirSave = layanan;
            layanan.setKurir(body);
            try {
                repo.save(kurirSave);
                resultMap.put("success", true);
                resultMap.put("message", "kurir detail saved");
            } catch (Exception e) {
                resultMap.put("success", true);
                resultMap.put("message", "kurir detail faileds");
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "no  data");
        }
        return resultMap;
	}

	public Map<String, Object> deleteKurir(String id) {
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
            update.unset("kurir");
            mongotemp.updateMulti(query, update, LayananKurir.class);
            result.put("success", true);
            result.put("message", "berhasil dihapus");
        } catch (final Exception e) {
            result.put("success", false);
            result.put("message", "gagal dihapus");
        }
        return result;
	}

	public Map<String, Object> updateKurir(Kurir body,String id) {
		 //ambil data berdasarkan id 
         LayananKurir layanan = repo.findById(id).get();
         Map<String, Object> resultMap = new HashMap<>();
         //jika data ada
        if (layanan != null) {
                LayananKurir kurirSave = layanan;
                //set detail user berdasarkan input
                layanan.setKurir(body);
            try {
                
                repo.save(kurirSave);
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

	public Kurir getByLayananId(String id) {
		LayananKurir layanan = repo.findById(id).get();
        Kurir kurir = layanan.getKurir();
        return kurir;
	}

	
    
}