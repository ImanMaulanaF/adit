package com.example.abude.ui.purchase;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.abude.ui.login.Login;
import com.example.abude.ui.pengeluaran.Pengeluaran;
import com.example.abude.R;

public class Beranda_Purchasing extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_purchasing);
        Button exit = findViewById(R.id.logout);
        Button pengeluaran = findViewById(R.id.pengeluaran);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Beranda_Purchasing.this, Login.class));
            }
        });
        pengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                startActivity(new Intent(Beranda_Purchasing.this, Pengeluaran.class));
            }
        });
    }
}