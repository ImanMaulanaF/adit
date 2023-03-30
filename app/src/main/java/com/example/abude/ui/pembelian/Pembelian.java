package com.example.abude.ui.pembelian;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.abude.R;
import com.example.abude.adapter.BarangPembelianAdapter;
import com.example.abude.adapter.RiwayatPembelianAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class Pembelian extends AppCompatActivity {
//    RecyclerView recyclerView;
//    LinearLayoutManager linearLayoutManager;
//    AdapterData adapterData;
//    List<String> listdata;
    private TextView jumlah, totalHarga;
    private Button stok, pembelian, logout;
    private EditText waktu;
    private ImageButton btn_tambah, btn_kurang, btn_submit, btn_date, date;
    private Spinner menu, konsumen;
    private AlertDialog builder;

    private TextView tvBarang;

    private RecyclerView rvBarang;

    private ProgressBar progressBar;

    private ArrayList<String> listBarang = new ArrayList<>();


    public void getNamaBarang() {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://abude.mythologica.xyz/API/Barang";
        client.addHeader("Authorization", "");
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                listBarang = new ArrayList<>();

                progressBar.setVisibility(View.INVISIBLE);

                String result = new String(responseBody);

                try {
                    JSONArray jsonArray = new JSONArray(result);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String namaBarang = jsonObject.getString("nama_barang");
                        String hargaBarang = jsonObject.getString("harga_barang");

                        listBarang.add(namaBarang + " - Rp." + hargaBarang);

                    }

                    BarangPembelianAdapter adapter = new BarangPembelianAdapter(listBarang);
                    rvBarang.setAdapter(adapter);



                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                String errorMessage;

                switch (statusCode) {
                    case 401:
                        errorMessage = statusCode + ": Bad Request";
                        break;
                    case 404:
                        errorMessage = statusCode + ": KDD REQUESTNYA";
                        break;
                    default:
                        errorMessage = "Kesalahan";
                        break;
                }
            }
        });
    }

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

        rvBarang = findViewById(R.id.rv_barang);
        progressBar = findViewById(R.id.progressBar);

//        getNamaBarang();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvBarang.setLayoutManager(layoutManager);

        getNamaBarang();

//        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(Pembelian.this, android.R.layout.simple_spinner_item, dataSpinner);
//        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
//        menu.setAdapter(spinnerArrayAdapter);

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