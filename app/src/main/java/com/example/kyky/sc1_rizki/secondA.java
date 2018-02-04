package com.example.kyky.sc1_rizki;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class secondA extends AppCompatActivity {

    //    Deklarasi variabel
    int uang = 65000;
    int biaya, total,hargaTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondac);
        TextView Makanan = (TextView) findViewById(R.id.makanan);
        TextView Qty = (TextView) findViewById(R.id.qty);
        TextView lokasi = (TextView) findViewById(R.id.lokasi);
        TextView hasil = (TextView) findViewById(R.id.harga);
//        untuk mendapatkan intent dari layout 1
        Intent i = getIntent();



//      Receive
        String makanan = i.getStringExtra("makanan");
        String Lokasi = i.getStringExtra("tempat");
        String qty = i.getStringExtra("porsi");

//      Display
        Makanan.setText(makanan);
        Qty.setText(qty);
        lokasi.setText(Lokasi);

        switch (Lokasi) {
            case "EatBus":
                biaya = 50000;
                break;

            case "Abnormal":
                biaya = 30000;
                break;

        }
        total = parseInt(qty) * biaya;
        String hargaTotal = Integer.toString(total);
        if (uang < total) {
            hasil.setText("Rp" + hargaTotal);
            Toast.makeText(this, "Jangan disini makan malamnya, uang kamu tidak cukup", Toast.LENGTH_SHORT).show();
        } else {
            hasil.setText("Rp" + hargaTotal);
            Toast.makeText(this, "Disini Aja makan malamnya", Toast.LENGTH_SHORT).show();
        }

    }
}
