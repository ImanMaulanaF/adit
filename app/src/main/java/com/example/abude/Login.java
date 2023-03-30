package com.example.abude;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.loginButton);
        EditText userEntry = findViewById(R.id.username);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userEntry.getText().toString();
                if (user.equals("admin")){
                    startActivity(new Intent(Login.this, Beranda_Admin.class));
                }else if(user.equals("purchasing")){
                    startActivity(new Intent(Login.this, Beranda_Purchasing.class));
                }else if (user.equals("owner")){
                    startActivity(new Intent(Login.this, Beranda_Owner.class));
                }else{
                    Toast toast= Toast.makeText(getApplicationContext(), "Username / Password Salah", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP| Gravity.START, 90, 0);
                    toast.show();
                }
            }
        });
    }
}