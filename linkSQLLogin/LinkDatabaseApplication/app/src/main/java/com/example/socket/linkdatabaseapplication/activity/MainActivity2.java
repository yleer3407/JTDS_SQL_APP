package com.example.socket.linkdatabaseapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.socket.linkdatabaseapplication.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String data = intent.getStringExtra("floNum");
        TextView textView = findViewById(R.id.txt1);
        textView.setText(data);
    }
}