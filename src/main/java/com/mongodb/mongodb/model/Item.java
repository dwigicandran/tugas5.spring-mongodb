package com.mongodb.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {
    @Id
    private String id;
    private String nama,description;
    private int stock,harga,terjual,berat;


    public Item() {
    }

    public Item(String id, String nama, String description, int stock, int harga, int terjual, int berat) {
        this.id = id;
        this.nama = nama;
        this.description = description;
        this.stock = stock;
        this.harga = harga;
        this.terjual = terjual;
        this.berat = berat;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getHarga() {
        return this.harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getTerjual() {
        return this.terjual;
    }

    public void setTerjual(int terjual) {
        this.terjual = terjual;
    }

    public int getBerat() {
        return this.berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public Item id(String id) {
        this.id = id;
        return this;
    }

    public Item nama(String nama) {
        this.nama = nama;
        return this;
    }

    public Item description(String description) {
        this.description = description;
        return this;
    }

    public Item stock(int stock) {
        this.stock = stock;
        return this;
    }

    public Item harga(int harga) {
        this.harga = harga;
        return this;
    }

    public Item terjual(int terjual) {
        this.terjual = terjual;
        return this;
    }

    public Item berat(int berat) {
        this.berat = berat;
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nama='" + getNama() + "'" +
            ", description='" + getDescription() + "'" +
            ", stock='" + getStock() + "'" +
            ", harga='" + getHarga() + "'" +
            ", terjual='" + getTerjual() + "'" +
            ", berat='" + getBerat() + "'" +
            "}";
    }

}