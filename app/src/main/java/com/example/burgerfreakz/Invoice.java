package com.example.burgerfreakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Invoice extends AppCompatActivity {

    private String name,address,method,product,quantity,unit,total,service,net;
    private TextView iName,iAddress,iProduct,iQuantity,iUnit,iTotal,iService,iNet,iMethod;

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
        iService = findViewById(R.id.iServ);
        iNet = findViewById(R.id.iNet);

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
        service = intent.getStringExtra("service");
        net = intent.getStringExtra("net");

        iName.setText(name);
        iAddress.setText(address);
        iMethod.setText(method);
        iProduct.setText(product);
        iQuantity.setText(quantity);
        iUnit.setText(unit);
        iTotal.setText(total);
        iService.setText(service);
        iNet.setText(net);

    }
}