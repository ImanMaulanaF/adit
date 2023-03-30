package com.example.abude.ui.admin;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.abude.adapter.RiwayatPembelianAdapter;
import com.example.abude.model.RiwayatModel;
import com.example.abude.ui.login.Login;
import com.example.abude.ui.pembelian.Pembelian;
import com.example.abude.R;
import com.example.abude.ui.stok.Stok;
import com.example.abude.adapter.Adapter_RecyclerView_Beranda;

import java.sql.Array;
import java.util.ArrayList;

public class Beranda_Admin extends AppCompatActivity {
    private EditText jenisKonsumen;
    private ArrayList<String> konsumenList;
    private Adapter_RecyclerView_Beranda adapter_recyclerView_beranda;

    // STEP 13 declare rv nya
    private RecyclerView rvRiwayat;
    private ArrayList<RiwayatModel> list = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        setContentView(R.layout.activity_beranda_admin);

        // STEP 14, deklarasi ambil ID rv nya sesuai dengan view di .xml
        rvRiwayat = findViewById(R.id.recycler_view);
        rvRiwayat.setHasFixedSize(true);

        // STEP 17, panggil function
        list.addAll(getListRiwayat());
        showRecyclerList();

        Button exit = findViewById(R.id.logout);
        Button pembelian = findViewById(R.id.pembelian);
        Button stok = findViewById(R.id.stok);


        konsumenList = new ArrayList<>();
        konsumenList.add("Umum");
        konsumenList.add("Pejabat DPR");
        adapter_recyclerView_beranda = new Adapter_RecyclerView_Beranda(konsumenList);
        recyclerView = findViewById(R.id.recycler_view);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Beranda_Admin.this, Login.class));
            }
        });
        pembelian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Beranda_Admin.this, Pembelian.class));
            }
        });

        stok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Beranda_Admin.this, Stok.class));
            }
        });

    }

    // STEP 15, bikin list nya
    public ArrayList<RiwayatModel> getListRiwayat() {
        String[] dataJenisKonsumen = getResources().getStringArray(R.array.jenis_konsumen);

        ArrayList<RiwayatModel> listRiwayat = new ArrayList<>();
        for (int i = 0; i < dataJenisKonsumen.length; i++) {
            RiwayatModel model = new RiwayatModel();
            model.setJenisKonsumen(dataJenisKonsumen[i]);

            listRiwayat.add(model);
        }

        return listRiwayat;
    }

    // STEP 16, bikin list recyclerView
    private void showRecyclerList() {
        rvRiwayat.setLayoutManager(new LinearLayoutManager(this));
        RiwayatPembelianAdapter adapter = new RiwayatPembelianAdapter(list);
        rvRiwayat.setAdapter(adapter);
    }
}