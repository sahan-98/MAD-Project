package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class Customize extends AppCompatActivity {



    TextView productName, price;
    Spinner size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);


        productName = findViewById(R.id.txtCustomize);
        price = findViewById(R.id.custPrice);
        size = findViewById(R.id.txtsize);


    }

    public void Buynow(View view){
        String pPrice,pName,pSize;

        pName = productName.getText().toString();
        pPrice = price.getText().toString();


        Intent intent = new Intent(Customize.this,shoppingcart.class);
        intent.putExtra("pName", pName);
        intent.putExtra("pPrice", pPrice);
        startActivity(intent);
    }


}