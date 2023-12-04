package com.raflisalam.appteman.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.raflisalam.appteman.R;
import com.raflisalam.appteman.database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button login;
    TextView register;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);

        username = (EditText)findViewById(R.id.inputUsername);
        password = (EditText)findViewById(R.id.inputPassword);
        login = (Button)findViewById(R.id.btnLogin);
        register = (TextView)findViewById(R.id.btnBelumDaftar);

        //register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
                finish();
            }
        });

        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                Boolean masuk = db.checkLogin(strUsername, strPassword);
                if (masuk == true) {
                    Boolean updateSession = db.upgradeSession("ada", 1);
                    if (updateSession == true) {
                        Toast.makeText(getApplicationContext(), "Berhasil Masuk", Toast.LENGTH_SHORT).show();
                        Intent mainIntent = new Intent(LoginActivity.this, HomeActivity.class);
                        mainIntent.putExtra("username", strUsername);
                        startActivity(mainIntent);
                        finish();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Gagal Masuk", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}