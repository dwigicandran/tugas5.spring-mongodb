package com.mongodb.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class LayananKurir {
    @Id
    private String id;
    private String nama,estimasi;
    private int harga;
    private Kurir kurir;


    public LayananKurir() {
    }

    public LayananKurir(String id, String nama, String estimasi, int harga, Kurir kurir) {
        this.id = id;
        this.nama = nama;
        this.estimasi = estimasi;
        this.harga = harga;
        this.kurir = kurir;
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

    public String getEstimasi() {
        return this.estimasi;
    }

    public void setEstimasi(String estimasi) {
        this.estimasi = estimasi;
    }

    public int getHarga() {
        return this.harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Kurir getKurir() {
        return this.kurir;
    }

    public void setKurir(Kurir kurir) {
        this.kurir = kurir;
    }

    public LayananKurir id(String id) {
        this.id = id;
        return this;
    }

    public LayananKurir nama(String nama) {
        this.nama = nama;
        return this;
    }

    public LayananKurir estimasi(String estimasi) {
        this.estimasi = estimasi;
        return this;
    }

    public LayananKurir harga(int harga) {
        this.harga = harga;
        return this;
    }

    public LayananKurir kurir(Kurir kurir) {
        this.kurir = kurir;
        return this;
    }

   

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nama='" + getNama() + "'" +
            ", estimasi='" + getEstimasi() + "'" +
            ", harga='" + getHarga() + "'" +
            ", kurir='" + getKurir() + "'" +
            "}";
    }


}