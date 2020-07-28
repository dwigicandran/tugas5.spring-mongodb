package com.mongodb.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class DetailUser {
   
    @Id
    private String id;
    private String alamat,phone1,phone2,type,jenis_kelamin;
    private int kode_pos;

    public DetailUser() {
    }

    public DetailUser(String id, String alamat, String phone1, String phone2, String type, String jenis_kelamin, int kode_pos) {
        this.id = id;
        this.alamat = alamat;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.type = type;
        this.jenis_kelamin = jenis_kelamin;
        this.kode_pos = kode_pos;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPhone1() {
        return this.phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return this.phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJenis_kelamin() {
        return this.jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public int getKode_pos() {
        return this.kode_pos;
    }

    public void setKode_pos(int kode_pos) {
        this.kode_pos = kode_pos;
    }

    public DetailUser id(String id) {
        this.id = id;
        return this;
    }

    public DetailUser alamat(String alamat) {
        this.alamat = alamat;
        return this;
    }

    public DetailUser phone1(String phone1) {
        this.phone1 = phone1;
        return this;
    }

    public DetailUser phone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public DetailUser type(String type) {
        this.type = type;
        return this;
    }

    public DetailUser jenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
        return this;
    }

    public DetailUser kode_pos(int kode_pos) {
        this.kode_pos = kode_pos;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", alamat='" + getAlamat() + "'" +
            ", phone1='" + getPhone1() + "'" +
            ", phone2='" + getPhone2() + "'" +
            ", type='" + getType() + "'" +
            ", jenis_kelamin='" + getJenis_kelamin() + "'" +
            ", kode_pos='" + getKode_pos() + "'" +
            "}";
    }

}