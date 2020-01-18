package com.example.projekkasirkingarage.Objek;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Transaksi implements Serializable {
    private String nama_pembeli;
    private String nomor_meja;

    private ArrayList<MenuCafe> menuCafes;

    private int total_harga;

    private int total_semua_harga = 0;

    public Transaksi() {
        menuCafes = new ArrayList<MenuCafe>();
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public int getTotal_semua_harga() {
        return total_semua_harga;
    }

    public void setTotal_semua_harga(int total_harga) {
        this.total_semua_harga = this.total_semua_harga + total_harga;
    }

    public ArrayList<MenuCafe> getMenuCafes() {
        return menuCafes;
    }

    public void tambahTransaksi(MenuCafe menu) {
        menuCafes.add(menu);
    }
}
