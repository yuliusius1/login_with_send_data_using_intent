package com.coba.tugas2_672019014;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_fullname_regist, et_username_regist, et_password_regist, et_conf_password_regist;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_fullname_regist = findViewById(R.id.et_fullname_regist);
        et_username_regist = findViewById(R.id.et_username_regist);
        et_password_regist = findViewById(R.id.et_password_regist);
        et_conf_password_regist = findViewById(R.id.et_conf_password_regist);

        btn_register = findViewById(R.id.btn_register);
    }

    public void register(View v){
        int foundError = 0;
        if(TextUtils.isEmpty(et_fullname_regist.getText().toString())){
            et_fullname_regist.setError("Fullname must be filled out!");
            foundError = 1;
        }

        if(TextUtils.isEmpty(et_username_regist.getText().toString())){
            et_username_regist.setError("Username must be filled out!");
            foundError = 1;
        }

        if(TextUtils.isEmpty(et_password_regist.getText().toString())){
            et_password_regist.setError("Password must be filled out!");
            foundError = 1;
        }

        if(TextUtils.isEmpty(et_conf_password_regist.getText().toString())){
            et_conf_password_regist.setError("Confirm Password must be filled out!");
            foundError = 1;
        }

        if(!TextUtils.equals(et_password_regist.getText().toString(),et_conf_password_regist.getText().toString())){
            et_conf_password_regist.setError("Password must be same !");
            et_password_regist.setError("Password must be same!");
            foundError = 1;
        }

        if(foundError != 1){
            Toast.makeText(MainActivity.this,"Register Successful", Toast.LENGTH_SHORT).show();

            // Intent Progress
            String fullname = et_fullname_regist.getText().toString();
            String username = et_username_regist.getText().toString();
            String password = et_password_regist.getText().toString();

            Intent intent = new Intent(this,LoginActivity.class);

            intent.putExtra("fullname", fullname);
            intent.putExtra("username", username);
            intent.putExtra("password", password);

            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this,"Register Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }
}