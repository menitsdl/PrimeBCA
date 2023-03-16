package com.example.primebca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
        TextView textView,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        textView.setText(getIntent().getStringExtra("message"));
        textView2.setText(getIntent().getStringExtra("nextMessage"));
    }
}