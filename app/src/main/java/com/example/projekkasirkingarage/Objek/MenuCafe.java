package com.example.projekkasirkingarage.Objek;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuCafe implements Serializable {
    private String nama;
    private int harga;
    private int jumlah;

    public MenuCafe(String nama, int harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    protected MenuCafe(Parcel in) {
        nama = in.readString();
        harga = in.readInt();
        jumlah = in.readInt();
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
