package com.example.projekkasirkingarage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.projekkasirkingarage.Objek.MenuCafe;
import com.example.projekkasirkingarage.Objek.Transaksi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String DETAIL_ORDER = "Detail Order";
    public static final String ITEM_DETAIL = "Item Detail";

    String resultItem;
    String resultData;

    TextView itemCheckout;
    TextView totalItem;
    TextView coba;

    float countPrice = 0;
    int totalItemSelected = 0;

    EditText noMeja;
    EditText nameOrder;
    Button btnCheckout;
    Spinner spinner;
    EditText jPrice;
    CardView cart;

    int[] price = {1000, 2000, 3000};

    Transaksi transaksi = new Transaksi();
    MenuCafe menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        addSpinner();
        addDetailOrder();

        cart = findViewById(R.id.cart_menu);
        cart.setVisibility(cart.INVISIBLE);

//        Custom Menu
        addMenu();
        removeMenu();

//        Checkout Order
        checkoutOrder();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void addSpinner() {
        spinner = findViewById(R.id.idSpinnerMenu);
        String[] contries = {"Menu01", "Menu02", "Menu03"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, contries);
        spinner.setAdapter(adapter);
    }

    public void addDetailOrder() {
        nameOrder = findViewById(R.id.namePembeli);
        noMeja = findViewById(R.id.noMeja);
        jPrice = findViewById(R.id.totalItemChoose);
    }

    public void btnClickCheckout(View v) {

//        Intent intent = new Intent(this, CheckoutAndPrint.class);
//        intent.putExtra(DETAIL_ORDER, new String[]{nameOrder.getText().toString(),
//                noMeja.getText().toString()});
//
//        startActivity(intent);
        ArrayList<MenuCafe> object = new ArrayList<MenuCafe>();
        Intent intentParcel = new Intent(this, CheckoutAndPrint.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable("ARRAYLIST", transaksi.getMenuCafes()); // MenuCafe juga harus Serializable
        intentParcel.putExtra("BUNDLE", bundle);

        startActivity(intentParcel);
    }

    public void addMenu() {
        Button buttonTambah = (Button) findViewById(R.id.tambahItem);
        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!jPrice.getText().toString().isEmpty()) {
                    cart.setVisibility(cart.VISIBLE);

                    String nameMenu = spinner.getSelectedItem().toString();
                    int resultMenu = spinner.getSelectedItemPosition();
                    int resultTotal = Integer.parseInt(jPrice.getText().toString());

                    menu = new MenuCafe(nameMenu, price[resultMenu], resultTotal);
                    transaksi.tambahTransaksi(menu);

                    totalItemSelected = totalItemSelected + resultTotal;
                    countPrice = countPrice + (price[resultMenu] * resultTotal);

                    String item = Integer.toString(totalItemSelected);
                    String resultItem = item + " Item Dipilih";
                    itemCheckout.setText(resultItem);

                    String resultData = "Rp " + String.format("%,.0f", countPrice);
                    totalItem.setText(resultData);

                    ArrayList<MenuCafe> allItem = transaksi.getMenuCafes();

                    for (MenuCafe itm : allItem) {
                        System.out.println(itm.getNama());
                    }
                }
            }
        });
    }

    public void removeMenu() {
        Button buttonKurang = (Button) findViewById(R.id.kurangItem);
        buttonKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int resultMenu = spinner.getSelectedItemPosition();
                int resultTotal = Integer.parseInt(jPrice.getText().toString());

                totalItemSelected = totalItemSelected - resultTotal;
                countPrice = countPrice - (price[resultMenu] * resultTotal);

                String item = Integer.toString(totalItemSelected);
                resultItem = item + " Item Dipilih";
                itemCheckout.setText(resultItem);

                resultData = "Rp " + String.format("%,.0f", countPrice);
                totalItem.setText(resultData);

                if (totalItemSelected == 0 || totalItemSelected < 0 || countPrice < 0) {
                    totalItemSelected = 0;
                    countPrice = 0;
                    cart.setVisibility(cart.INVISIBLE);
                }
            }
        });
    }

    public void checkoutOrder() {
        coba = findViewById(R.id.cobaSaja);
        itemCheckout = findViewById(R.id.itemGet);
        totalItem = findViewById(R.id.totalItemPrice);

        btnCheckout = findViewById(R.id.ck_out);
    }
}
