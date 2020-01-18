package com.example.projekkasirkingarage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.widget.TextView;

import com.example.projekkasirkingarage.Objek.MenuCafe;
import com.example.projekkasirkingarage.Objek.Transaksi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutAndPrint extends AppCompatActivity {

    Transaksi transaksiOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_and_print);
        Transaksi transaksi = new Transaksi();


//        // Get the Intent that started this activity and extract the string
//        Intent intentNama = getIntent();
////        Object nOrder = intentNama.getSerializableExtra("myClass");
//        String[] nOrder = intentNama.getStringArrayExtra(MainActivity.DETAIL_ORDER);
////
//        String orderDetail = "<b>" + "Nama Pembeli: " + nOrder[0] + "\t\t\t Nomor Meja : " + nOrder[1] + "</b>";
////
////        // Capture the layout's TextView and set the string as its text
//        TextView detail_order = findViewById(R.id.detailOrder);
////
//        detail_order.setText(Html.fromHtml(orderDetail));


//        Intent order = getIntent();
//        transaksiOutput = (Transaksi) order.getSerializableExtra("key_one");

//        ArrayList<MenuCafe> menus = transaksiOutput.getMenuCafes();


        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<MenuCafe> object = (ArrayList<MenuCafe>) args.getSerializable("ARRAYLIST");
//        System.out.println(object.size());
        String name = "";
        for (int i = 0; i < object.size(); i++) {
            name += object.get(i).getNama() + "\n";
        }

        TextView itemSel = findViewById(R.id.itemSelected);
        itemSel.setText(name);


//        for (MenuCafe item: name) {
//            System.out.println(item.getNama());
//        }

    }
}
