package com.example.burgerfreakz;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.burgerfreakz.Payment;
import com.example.burgerfreakz.R;

public class Continue extends AppCompatActivity {

    Button btnpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        btnpay = findViewById(R.id.btn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Continue.this, Payment.class);
                startActivity(intent);
            }
        });
    }
}