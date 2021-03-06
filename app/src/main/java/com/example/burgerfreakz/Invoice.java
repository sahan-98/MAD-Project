package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Invoice extends AppCompatActivity {

    private String name,address,method,product,quantity,unit,total,service,net,discount,username;
    private TextView iName,iAddress,iProduct,iQuantity,iUnit,iTotal,iDisc,iService,iNet,iMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        iName = findViewById(R.id.iName);
        iAddress = findViewById(R.id.iAddress);
        iMethod = findViewById(R.id.iMethod);
        iProduct = findViewById(R.id.iProd);
        iQuantity = findViewById(R.id.iQuan);
        iUnit = findViewById(R.id.iUnit);
        iTotal = findViewById(R.id.iTot);
        iDisc = findViewById(R.id.iDisc);
        iService = findViewById(R.id.iServ);
        iNet = findViewById(R.id.iNet);

        username = getIntent().getStringExtra("username");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        address = intent.getStringExtra("address");
        method = intent.getStringExtra("method");
        product = intent.getStringExtra("product");
        quantity = intent.getStringExtra("quant");
        unit = intent.getStringExtra("unit");
        total = intent.getStringExtra("total");
        discount = intent.getStringExtra("discount");
        service = intent.getStringExtra("service");
        net = intent.getStringExtra("net");

        iName.setText(name);
        iAddress.setText(address);
        iMethod.setText(method);
        iProduct.setText(product);
        iQuantity.setText(quantity);
        iUnit.setText(unit);
        iTotal.setText(total);
        iDisc.setText(discount);
        iService.setText(service);
        iNet.setText(net);

    }
    public void Home(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void AboutUs(View view){
        Intent intent = new Intent(this, Feedback.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void Menu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
}