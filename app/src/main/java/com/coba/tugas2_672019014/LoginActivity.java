package com.coba.tugas2_672019014;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    String fullname, username, password;
    EditText et_username_login, et_password_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        fullname = intent.getStringExtra("fullname");
        username = intent.getStringExtra("username");
        password = intent.getStringExtra("password");

        et_username_login = findViewById(R.id.et_username_login);
        et_password_login = findViewById(R.id.et_password_login);
    }

    public void login(View v){
        if(!TextUtils.isEmpty(et_username_login.getText().toString()) && !TextUtils.isEmpty(et_password_login.getText().toString())){
            if(TextUtils.equals(et_username_login.getText().toString(),username) && TextUtils.equals(et_password_login.getText().toString(),password)){
                Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();

                // Intent Progress
                Intent intent = new Intent(this,HomeActivity.class);

                intent.putExtra("fullname", fullname);

                startActivity(intent);

            } else if (!TextUtils.equals(et_username_login.getText().toString(),username)){
                Toast.makeText(LoginActivity.this,"Login Error! Wrong Username !",Toast.LENGTH_SHORT).show();
                et_username_login.setError("Wrong Username!");
            } else {
                Toast.makeText(LoginActivity.this,"Login Error! Wrong Password !",Toast.LENGTH_SHORT).show();
                et_password_login.setError("Wrong Password!");
            }
        }

        if(TextUtils.isEmpty(et_username_login.getText().toString())){
            et_username_login.setError("Username must be filled out");
        }

        if(TextUtils.isEmpty(et_password_login.getText().toString())){
            et_password_login.setError("Password must be filled out");
        }

    }
}

