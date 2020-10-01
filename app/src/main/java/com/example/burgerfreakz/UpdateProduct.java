package com.example.burgerfreakz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.burgerfreakz.Database.DBHelper;

public class UpdateProduct extends AppCompatActivity {
    EditText etName,etCode,etPrice,etSize;
    private DBHelper dbHandler;
    private Button editButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        dbHandler = new DBHelper(UpdateProduct.this);

        etName = (EditText) findViewById(R.id.etName);
        etCode = (EditText) findViewById(R.id.etCode);
        etPrice = (EditText) findViewById(R.id.etPrice);
        etSize = (EditText) findViewById(R.id.etSize);
        editButton = findViewById(R.id.btnUpd);

        final String id = getIntent().getStringExtra("Id");
        Product product = dbHandler.getProduct(Integer.parseInt(id));

        etName.setText(product.getProName());
        etCode.setText(product.getProCode());
        etPrice.setText(product.getProPrice());
        etSize.setText(product.getProSize());


        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etname = etName.getText().toString();
                String etcode = etCode.getText().toString();
                String etprice = etPrice.getText().toString();
                String etsize = etSize.getText().toString();

                Product product = new Product(Integer.parseInt(id),etname,etcode,etprice,etsize);
                int state = dbHandler.updateProduct(product);
                Intent intentUPD = new Intent(UpdateProduct.this, ProductList.class);
                startActivity(intentUPD);
            }
        });

    }
}