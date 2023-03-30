package com.example.abude.ui.pengeluaran;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abude.R;

import java.text.DateFormat;
import java.util.Calendar;

public class Pengeluaran extends AppCompatActivity {
private TextView  jumlah,totalHarga;
private Button stok, pembelian, logout;
private EditText waktu;
private ImageButton btn_tambah, btn_kurang, btn_submit, btn_date, date;
private Spinner barang;
private AlertDialog builder;
//private int banyaknya = Integer.parseInt(jumlah.getText().toString())+1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran);
        totalHarga = findViewById(R.id.totalHarga);
        jumlah = findViewById(R.id.jumlah);
        waktu = findViewById(R.id.waktu);
        btn_tambah = findViewById(R.id.btn_tambah);
        btn_kurang = findViewById(R.id.btn_kurang);
        btn_submit = findViewById(R.id.btn_submit);
        date = findViewById(R.id.date);
        barang = findViewById(R.id.barang);

//        stok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(Pengeluaran.this, Pembelian.class));
//            }
//        });
//        pembelian.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(Pengeluaran.this, login.class));
//            }
//        });



        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waktuin();
                totalin();
                tambahin();

            }
        });
        btn_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waktuin();
                int banyak = Integer.parseInt(jumlah.getText().toString());
                if(banyak<1){
                    Toast toast= Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.TOP| Gravity.START, 90, 0);
                    toast.show();
                }
                else{
                    kurangin();
                    totalin();
                }
            }
        });
        jumlah.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            totalin();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private void tambahin(){
    int nilai = Integer.parseInt(jumlah.getText().toString());
    nilai++;
    jumlah.setText(String.valueOf(nilai));
    totalin();
    }
    private void kurangin(){
        int nilai = Integer.parseInt(jumlah.getText().toString());
        nilai--;
        jumlah.setText(String.valueOf(nilai));
        totalin();
    }
    private void totalin(){
        String brg = barang.getSelectedItem().toString();
        int banyak = Integer.parseInt(jumlah.getText().toString());

        if(brg.equals("GULA")){
            totalHarga.setText("Rp." + 6750*banyak);
        } else if (brg.equals("CINCAU")) {
            totalHarga.setText("Rp."+5500*banyak);
        } else if (brg.equals("CAPPUCINO POWDER")){
            totalHarga.setText("Rp."+11000*banyak);
        } else if (brg.equals("ES Batu")) {
            totalHarga.setText("Rp."+6000*banyak);
        } else if (brg.equals("GELAS PLASTIK")) {
            totalHarga.setText("Rp."+25000*banyak);
        } else if (brg.equals("SEDOTAN")) {
            totalHarga.setText("Rp."+8000*banyak);
        } else if (brg.equals("SUSU")) {
            totalHarga.setText("Rp."+8000*banyak);
        }
    }
    private void waktuin(){
        Calendar kalender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(kalender.getTime());


        waktu.setText((currentDate));
    }
    private void masukan(){


    }
}