package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    private String name,address,product,quantity,unit,total,service,net,discount;
    private TextView pMethod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        pMethod = findViewById(R.id.pCard);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        address = intent.getStringExtra("address");
        product = intent.getStringExtra("product");
        quantity = intent.getStringExtra("quant");
        unit = intent.getStringExtra("unit");
        total = intent.getStringExtra("total");
        discount = intent.getStringExtra("discount");
        service = intent.getStringExtra("service");
        net = intent.getStringExtra("net");
    }

    public void Pay(View view){

        Toast.makeText(this, "Thank you for your payment ", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Invoice.class);
        intent.putExtra("name",name);
        intent.putExtra("address",address);
        intent.putExtra("method",pMethod.getText().toString());
        intent.putExtra("product",product);
        intent.putExtra("quant",quantity);
        intent.putExtra("unit",unit);
        intent.putExtra("total",total);
        intent.putExtra("discount",discount);
        intent.putExtra("service",service);
        intent.putExtra("net",net);
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