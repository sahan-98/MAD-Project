package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shoppingcart extends AppCompatActivity {

    Button btnContinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);

        btnContinue = findViewById(R.id.btnContinue);


    }

    @Override
    protected void onResume() {
        super.onResume();
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(shoppingcart.this,Continue.class);
                startActivity(intent);
            }
        });
    }


}