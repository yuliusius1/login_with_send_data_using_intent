package com.coba.tugas2_672019014;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    String fullname;
    TextView tv_welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        fullname = intent.getStringExtra("fullname");

        tv_welcome = findViewById(R.id.tv_welcome);
        tv_welcome.setText(getString(R.string.txtWelcome, fullname));


    }
}