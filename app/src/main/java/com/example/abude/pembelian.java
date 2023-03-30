package com.example.abude;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Pembelian extends AppCompatActivity {
//    RecyclerView recyclerView;
//    LinearLayoutManager linearLayoutManager;
//    AdapterData adapterData;
//    List<String> listdata;
    private TextView jumlah,totalHarga;
    private Button stok, pembelian, logout;
    private EditText waktu;
    private ImageButton btn_tambah, btn_kurang, btn_submit, btn_date, date;
    private Spinner menu, konsumen;
    private AlertDialog builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelian);
        totalHarga = findViewById(R.id.totalHarga);
        jumlah = findViewById(R.id.jumlah);
        waktu = findViewById(R.id.waktu);
        btn_tambah = findViewById(R.id.btn_tambah);
        btn_kurang = findViewById(R.id.btn_kurang);
        btn_submit = findViewById(R.id.btn_submit);
        date = findViewById(R.id.date);
        menu = findViewById(R.id.menu);

//        recyclerView = findViewById(R.id.history);
//        listdata = new ArrayList<>();
//
//        for (int i=0; i<10; i++){
//            listdata.add("data ke" + i);
//        }
//        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//         recyclerView.setLayoutManager(linearLayoutManager);
//
//        adapterData = new AdapterData(this, listdata);
//        recyclerView.setAdapter(adapterData);
//        adapterData.notifyDataSetChanged();


//        stok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(Pembelian.this, Pengeluaran.class));
//            }
//
//        });
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(Pembelian.this, login.class));
//            }
//        });

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waktuin();
                tambahin();
                totalin();
            }
        });
        btn_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waktuin();
                int banyak = Integer.parseInt(jumlah.getText().toString());
                if(banyak<1){
                    builder.setTitle("PERHATIAN!!");
                    builder.setMessage("Kamu Tidak Dapat Mengurangi Jumlah Lebih Kecil Dari 0");
                    builder.setCancelable(true);
                    builder.show();
                }
                else{
                    kurangin();
                    totalin();
                }
            }
        });
//        jumlah.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                totalin();
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
    }
    private void tambahin(){
        int nilai;
        nilai = Integer.parseInt(jumlah.getText().toString());
        nilai++;
        jumlah.setText(String.valueOf(nilai));
    }
    private void kurangin(){
        int nilai = Integer.parseInt(jumlah.getText().toString());
        nilai = nilai-1;
        jumlah.setText(Integer.toString(nilai));
    }
    private void totalin(){
        String brg = menu.getSelectedItem().toString();
        int banyak = Integer.parseInt(jumlah.getText().toString());

        if(brg.equals("CAPPUCINO CINCAU")) {
            totalHarga.setText("Rp." + 6000*banyak);
        }else {
            totalHarga.setText(0);
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