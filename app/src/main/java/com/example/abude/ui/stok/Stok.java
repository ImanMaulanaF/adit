package com.example.abude.ui.stok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.abude.R;
import com.example.abude.ui.admin.Beranda_Admin;

public class Stok extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stok);

        Button exit = findViewById(R.id.logout);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Stok.this, Beranda_Admin.class));
            }
        });
    }
}