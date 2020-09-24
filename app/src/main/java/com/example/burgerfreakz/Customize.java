package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class Customize extends AppCompatActivity {



    TextView productName, price;
    RadioGroup sizeGroup;
    RadioButton radioSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);


        productName = findViewById(R.id.txtCustomize);
        price = findViewById(R.id.custPrice);
        sizeGroup = findViewById(R.id.sizeGroup);


    }

    public void Buynow(View view){
        String pPrice,pName,pSize;

        int selectedId = sizeGroup.getCheckedRadioButtonId();
        radioSize = findViewById(selectedId);



        pSize = radioSize.getText().toString();
        pName = productName.getText().toString();
        pPrice = price.getText().toString();


        Intent intent = new Intent(Customize.this,shoppingcart.class);
        intent.putExtra("pName", pName);
        intent.putExtra("pPrice", pPrice);
        intent.putExtra("pSize", pSize);
        startActivity(intent);
    }

    public void Home(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void AboutUs(View view){
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);
    }

    public void Menu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}