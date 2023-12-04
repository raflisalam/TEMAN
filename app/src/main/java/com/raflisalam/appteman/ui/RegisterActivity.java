package com.raflisalam.appteman.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.raflisalam.appteman.R;
import com.raflisalam.appteman.database.DatabaseHelper;
import com.raflisalam.appteman.database.DatabaseUser;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button register;
    TextView login;
    EditText username, email, password, passwordConf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        username = (EditText)findViewById(R.id.formUsername);
        email = (EditText)findViewById(R.id.formEmail);
        password = (EditText)findViewById(R.id.formPassword);
        passwordConf = (EditText)findViewById(R.id.formRepeatPassword);
        register = (Button)findViewById(R.id.btnDaftar);
        login = (TextView)findViewById(R.id.btnSudahDaftar);

        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

        //register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strEmail = username.getText().toString();
                String strPassword = password.getText().toString();
                String strPasswordConf = passwordConf.getText().toString();
                if (strPassword.equals(strPasswordConf)) {
                    Boolean daftar  = db.insertUser(strUsername, strEmail, strPassword);
                    if (daftar == true) {
                        Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Daftar Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Password Tidak Cocok", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}