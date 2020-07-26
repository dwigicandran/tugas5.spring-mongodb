package com.mongodb.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Kurir {
    
    @Id
    private String id;
    private String nama,resi;


    public Kurir() {
    }

    public Kurir(String id, String nama, String resi) {
        this.id = id;
        this.nama = nama;
        this.resi = resi;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getResi() {
        return this.resi;
    }

    public void setResi(String resi) {
        this.resi = resi;
    }

    public Kurir id(String id) {
        this.id = id;
        return this;
    }

    public Kurir nama(String nama) {
        this.nama = nama;
        return this;
    }

    public Kurir resi(String resi) {
        this.resi = resi;
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nama='" + getNama() + "'" +
            ", resi='" + getResi() + "'" +
            "}";
    }



}